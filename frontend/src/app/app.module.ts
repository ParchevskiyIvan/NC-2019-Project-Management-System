import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { TableComponent } from './module/main-page/components/table/table.component';
import {RouterModule, Routes} from "@angular/router";
import { LoginBoxComponent } from './module/login-page/components/login-box/login-box.component';
import { TopbarComponent } from './module/bars/components/topbar/topbar.component';
import { TaskPageComponent } from './module/task-page/task-page.component';
import { SearchComponent } from './module/main-page/components/search/search.component';
import { BottombarComponent } from './module/bars/components/bottombar/bottombar.component';
import { ActionsComponent } from './module/task-page/components/actions/actions.component';
import { DetailsComponent } from './module/task-page/components/details/details.component';
import { DescriptionComponent } from './module/task-page/components/description/description.component';
import { AttachementsComponent } from './module/task-page/components/attachements/attachements.component';
import { CommentsComponent } from './module/task-page/components/comments/comments.component';
import {FormsModule} from "@angular/forms";
import { UserModalComponent } from './module/bars/components/user-modal/user-modal.component';
import { TaskModalComponent } from './module/bars/components/task-modal/task-modal.component';
import { ProjectModalComponent } from './module/bars/components/project-modal/project-modal.component';
import {InterceptorService} from "./service/auth/interceptor.service";
import { ErrorpageComponent } from './module/error/errorpage/errorpage.component';


@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    LoginBoxComponent,
    TopbarComponent,
    TaskPageComponent,
    SearchComponent,
    BottombarComponent,
    ActionsComponent,
    DetailsComponent,
    DescriptionComponent,
    AttachementsComponent,
    CommentsComponent,
    UserModalComponent,
    TaskModalComponent,
    ProjectModalComponent,
    ErrorpageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [InterceptorService,{provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
