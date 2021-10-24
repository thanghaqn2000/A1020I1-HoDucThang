import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../services/customer.service";
import {ICustomer} from "../model/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {ICustomerType} from "../model/typeCustomer";
import {TypeCustomerService} from "../services/type-customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers!:ICustomer[];
  public listType!:ICustomerType[];
  public searchName:string="";
  public searchType:string="";
  public name!:string;
  public id!:number;
  public messageCreate:string=this._service.MESSAGE_CREATE;
  public messageDelete!:string;
  constructor(private _service: CustomerService,private router:Router,private activeRouter:ActivatedRoute,private _serviceType:TypeCustomerService) {
  }

  // listCustomer: ICustomer[] = this._service.getAll();
  page: number=1;
  gender: string="";

  ngOnInit(): void {
    this._service.getAllApi().subscribe(data=>{
        this.customers=data;
    });
    this._serviceType.getAllType().subscribe(data=>{
      // @ts-ignore
      this.listType=data;
    })
  }

  deleteCus(id:number){
    this._service.delete(id).subscribe(data=>{
      this.messageDelete="Delete success customer: "+this.name;
      // this.router.navigateByUrl('listCus');
      this.ngOnInit();
    })
  }

  getCustomerName(id:number){
    this._service.findById(id).subscribe(data=>{
        this.name=data.name;
        this.id=data.id;
    });
  }

  doSearch(){
    this._service.search3Way(this.searchName,this.gender,this.searchType).subscribe(
      (data) => this.customers = data
    );
  }
}
