import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {NgxPaginationModule} from 'ngx-pagination';
import {EmployeeCreateComponent} from "./employee-create/employee-create.component";
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeDetailComponent} from "./employee-detail/employee-detail.component";

const routes: Routes = [
  {path: 'createEmp', component: EmployeeCreateComponent},
  {path: 'listEmp', component: EmployeeListComponent},
  {path: 'detailEmp/:id', component: EmployeeDetailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes),
   NgxPaginationModule],
  exports: [RouterModule],

})
export class EmployeeRoutingModule {
}
