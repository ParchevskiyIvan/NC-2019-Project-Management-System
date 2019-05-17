import { NgModule } from '@angular/core';
import { LoginBoxComponent } from './components/login-box/login-box.component';
import {UserService} from "../../service/user/user.service";
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";
import {AuthService} from "../../service/auth/auth.service";
import {InterceptorService} from "../../service/auth/interceptor.service";
import {RoleService} from "../../service/role/role.service";

@NgModule({
  declarations: [LoginBoxComponent],
  imports: [
    FormsModule,
    HttpClientModule,
    RouterModule,
    BrowserModule
  ],
  exports: [
    LoginBoxComponent
  ],
  providers:[
    UserService,
    RoleService,AuthService, InterceptorService, {provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true}
  ]
})
export class HomepageModule { }
