import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environment/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private SERVER_URL =  `${environment.apiUrl}/api`;

  constructor(private httpClient: HttpClient) { }

  public getContries(pageIndex: number, pageSize: number): Observable<any> {
    return this.httpClient.get(this.SERVER_URL+"/world-bank/countries/"+pageIndex+"/"+pageSize);
  }

  public getIndicador(id: number, pageIndex: number, pageSize: number): Observable<any> {
    return this.httpClient.get(this.SERVER_URL+"/world-bank/indicator/"+id+"/"+pageIndex+"/"+pageSize);
  }
}
