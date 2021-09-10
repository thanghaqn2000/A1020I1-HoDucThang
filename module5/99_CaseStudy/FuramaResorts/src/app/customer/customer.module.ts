import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerDetailComponent,
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule
  ]
})
export class CustomerModule { }
