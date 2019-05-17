import { NgModule } from '@angular/core';
import { BottombarComponent } from './components/bottombar/bottombar.component';
import { TopbarComponent } from './components/topbar/topbar.component';
import {UserService} from "../../service/user/user.service";
import {RoleService} from "../../service/role/role.service";
import {FormsModule} from "@angular/forms";
import {UserModalComponent} from "./components/user-modal/user-modal.component";
import {TaskModalComponent} from "./components/task-modal/task-modal.component";
import {ProjectModalComponent} from "./components/project-modal/project-modal.component";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";
import {ProjectService} from "../../service/project/project.service";
import {StatusService} from "../../service/status/status.service";

@NgModule({
  declarations: [
    BottombarComponent,
    TopbarComponent,
    UserModalComponent,
    TaskModalComponent,
    ProjectModalComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    RouterModule,
    BrowserModule
  ],
  exports: [
    BottombarComponent,
    TopbarComponent,
    UserModalComponent,
    TaskModalComponent,
    ProjectModalComponent,
    ProjectModalComponent
  ],
  providers:[
    UserService,
    RoleService,
    ProjectService,
    StatusService
  ]
})
export class HomepageModule { }
