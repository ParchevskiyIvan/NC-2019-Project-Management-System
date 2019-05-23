import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { TableComponent } from './module/main-page/components/table/table.component';
import { LoginBoxComponent } from './module/login-page/components/login-box/login-box.component';
import { TopbarComponent } from './module/bars/components/topbar/topbar.component';
import { TaskPageComponent } from './module/task-page/task-page.component';
import { CommentsComponent } from './module/task-page/components/comments/comments.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UserModalComponent } from './module/bars/components/user-modal/user-modal.component';
import { TaskModalComponent } from './module/bars/components/task-modal/task-modal.component';
import { ProjectModalComponent } from './module/bars/components/project-modal/project-modal.component';
import {InterceptorService} from "./service/auth/interceptor.service";


@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    LoginBoxComponent,
    TopbarComponent,
    TaskPageComponent,
    CommentsComponent,
    UserModalComponent,
    TaskModalComponent,
    ProjectModalComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [InterceptorService,{provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
