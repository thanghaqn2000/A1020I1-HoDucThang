import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TypeCustomerService {
 public API:string="http://localhost:3000/customerTypes";
  constructor(private http:HttpClient) { }

  getAllType(){
    return this.http.get(this.API);
  }
}
