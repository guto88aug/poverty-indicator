import {Component, OnInit, ViewChild} from '@angular/core';
import {ApiService} from "../service/api.service";
import {PaginationCountry} from "../shared/models/pagination-country.model";
import {MatPaginator, PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  countries: PaginationCountry = new PaginationCountry();
  displayedColumns: string[] = ['id', 'name', 'capitalCity'];

  @ViewChild(MatPaginator) paginator: any = MatPaginator;

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.buscarPaisFiltro(1, 10);
  }


  private buscarPaisFiltro(pageIndex: number, pageSize: number) {
    this.apiService.getContries(pageIndex, pageSize)
      .subscribe({
        next: (res) => {
          this.countries = res;
        },
      });
  }

  number(total: String) {
    return Number(total);
  }

  onPageChange(event: PageEvent) {
    this.buscarPaisFiltro(++event.pageIndex, event.pageSize);
  }
}
