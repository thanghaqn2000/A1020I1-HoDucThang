import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {NgxPaginationModule} from 'ngx-pagination';
import {CustomerCreateComponent} from "./customer-create/customer-create.component";
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerDetailComponent} from "./customer-detail/customer-detail.component";

const routes: Routes = [
  {path: 'createCus', component: CustomerCreateComponent},
  {path: 'listCus', component: CustomerListComponent},
  {path: 'detailCus/:id', component: CustomerDetailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes),
   NgxPaginationModule],
  exports: [RouterModule],

})
export class CustomerRoutingModule {
}
