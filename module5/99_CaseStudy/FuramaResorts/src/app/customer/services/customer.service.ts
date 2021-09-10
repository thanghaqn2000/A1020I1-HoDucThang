import {Injectable} from '@angular/core';
import { ICustomer} from "../model/customer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API:string="http://localhost:3000/customers";



  constructor(public http:HttpClient) {
  }

  getAllApi():Observable<any> {
    return this.http.get(this.API+"?_sort=cus_id&_order=asc");
  }


  findById(id:number):Observable<ICustomer>{
    return this.http.get<ICustomer>(this.API+"/"+id);
  }
  search(search: string): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.API + '?name_like=' + search);
  }

  create(customer:ICustomer):Observable<any>{
    return this.http.post<any>(this.API,customer);
  }

  delete(id:number):Observable<any>{
    return this.http.delete<any>(this.API+"/"+id)
  }
  update(id:any,customer:ICustomer):Observable<ICustomer>{
    return this.http.put<ICustomer>(this.API+"/"+id,customer);
  }

}
