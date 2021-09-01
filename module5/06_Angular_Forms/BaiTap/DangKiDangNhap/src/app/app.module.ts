import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DangKiComponent} from './components/dang-ki/dang-ki.component';
import {DangNhapComponent} from './components/dang-nhap/dang-nhap.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ListComponent } from './components/list/list.component';

@NgModule({
  declarations: [
    AppComponent,
    DangKiComponent,
    DangNhapComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
