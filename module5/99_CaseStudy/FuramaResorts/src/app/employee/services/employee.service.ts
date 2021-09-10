import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../models/Employee";
import {ICustomer} from "../../customer/model/customer";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  API: string = "http://localhost:3000/employees";
  public API_POSITION:string="http://localhost:3000/position";
  public API_EDUCATION:string="http://localhost:3000/education";
  public API_DIVISION:string="http://localhost:3000/division";
  public MESSAGE_DELETE:string="Delete success";
  public MESSAGE_CREATE:string="Create success";
  constructor(public http: HttpClient) {
  }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.API);
  }
  getAllPosition():Observable<any>{
    return this.http.get(this.API_POSITION);
  }
  getAllEducation():Observable<any>{
    return this.http.get(this.API_EDUCATION);
  }
  getAllDivision():Observable<any>{
    return this.http.get(this.API_DIVISION);
  }
  findById(id: number): Observable<Employee> {
    return this.http.get<Employee>(this.API + "/" + id);
  }
  search(search:string):Observable<any>{
    return this.http.get<Employee[]>(this.API + '?name_like=' + search);
  }

  create(employee: Employee): Observable<any> {
    return this.http.post(this.API, employee);
  }

  update(id: any, employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.API + "/" + id, employee);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(this.API + "/" + id);
  }
}
