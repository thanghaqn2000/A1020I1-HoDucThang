import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "../app-routing.module";
import {NgxPaginationModule} from "ngx-pagination";



@NgModule({
  declarations: [
    EmployeeCreateComponent,
    EmployeeDetailComponent,
    EmployeeListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class EmployeeModule { }
