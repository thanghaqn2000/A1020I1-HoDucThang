import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormComponent } from './components/form/form.component';
import { DetailComponent } from './components/detail/detail.component';
import {RouterModule} from "@angular/router";
import { ListComponent } from './components/list/list.component';
import {DataServiceService} from "./service/data-service.service";
import {FormsModule} from "@angular/forms";
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    FormComponent,
    DetailComponent,
    ListComponent

  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    DataServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
