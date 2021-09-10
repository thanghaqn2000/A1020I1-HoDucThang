import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import {EmployeeListComponent} from "./employee/employee-list/employee-list.component";
import {CustomerRoutingModule} from "./customer/customer-routing.module";
import {EmployeeRoutingModule} from "./employee/employee-routing.module";
const routes: Routes = [

  {path: 'listEmp', component: EmployeeListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    Ng2SearchPipeModule,CustomerRoutingModule,EmployeeRoutingModule],
  exports: [RouterModule],

})
export class AppRoutingModule {
}
