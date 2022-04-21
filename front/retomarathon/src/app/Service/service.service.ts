import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url = 'http://localhost:8080/register/';

  register(tipo:string, ruc:string){
      return this.http.post(this.Url + tipo + '/'+ ruc ,null);
  }

}
