import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ApiService} from "../service/api.service";
import {PaginationCountry} from "../shared/models/pagination-country.model";
import {PaginationIndicator} from "../shared/models/pagination-indicator.model";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: any = MatPaginator;
  displayedColumns: string[] = ['name', 'data', 'id', 'value', 'valor'];

  formulario: any = null;

  id: number = 0;

  indicator: PaginationIndicator = new PaginationIndicator();
  showTable: boolean = false;
  showSpinner: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private apiService: ApiService,
    private snackBar: MatSnackBar
  ) {

  }

  ngOnInit(): void {
    this.contruirForm();
  }

  private contruirForm() {
    this.formulario = this.formBuilder.group({
      id: [null, Validators.required]
    });
  }

  validarPesquisa(pageIndex = 1, pageSize = 10) {
    if (this.formulario.valid) {
      let id = this.formulario.get("id").value;
      this.showSpinner = true;
      this.apiService.getIndicador(id, pageIndex, pageSize)
        .subscribe({
          next: (res) => {
            this.showSpinner = false;
            if (res == null) {
              this.showTable = false;
              this.snackBar.open("Sem registros para o país pesquisado."
                , "FECHAR", {
                  duration: 9000,
                });
            } else {
              this.showTable = true;
              this.indicator = res;
            }
          }
          , error: (err) => {
            this.showSpinner = false;
            this.showTable = false;
            this.snackBar.open("Código do país não encontrado. " +
              "Por favor acesse a funcionalidade \"Países\" no menu superior " +
              "e consulte corretamente o código do país"
              , "FECHAR", {
                duration: 9000,
              });
          }
        });
    }
  }

  number(total: String) {
    return Number(total);
  }

  onPageChange(event: PageEvent) {
    this.validarPesquisa(++event.pageIndex, event.pageSize);
  }
}
