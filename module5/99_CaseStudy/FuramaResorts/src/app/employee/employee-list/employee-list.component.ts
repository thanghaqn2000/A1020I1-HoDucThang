import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../services/employee.service";
import {Employee} from "../models/Employee";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  listEmp!: Employee[];
  page:number=1;
  public name!:string;
  public id!:number;
  public emp_id!:string;
  public searchValue!:string;

  constructor(private _service: EmployeeService) {
  }

  ngOnInit(): void {
    this._service.getAll().subscribe(data => {
      this.listEmp = data;
    })
  }
  delete(id:number){
    this._service.delete(id).subscribe(data=>{
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
    })
  }

  getEmpName(id:number){
    this._service.findById(id).subscribe(data=>{
      this.name=data.name;
      this.id=data.id;
      this.emp_id=data.emp_id;
    });
  }

  doSearch(){
    this._service.search(this.searchValue.trim()).subscribe(
      (data) => this.listEmp = data
    );
  }
}
