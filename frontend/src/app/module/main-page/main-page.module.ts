import { NgModule } from '@angular/core';
import { SearchComponent } from './components/search/search.component';
import { TableComponent } from './components/table/table.component';
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "../../app-routing.module";
import {CommonModule} from "@angular/common";
import {NgbModalModule, NgbModule, NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";
import {PaginationModule} from "ngx-bootstrap";


@NgModule({
  declarations: [SearchComponent, TableComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    NgbModalModule.forRoot(),
    NgbModule.forRoot(),
    FormsModule,
    NgbPaginationModule.forRoot(),
    PaginationModule
  ],
  exports: [
    TableComponent, SearchComponent
  ],
  bootstrap:[
    TableComponent
  ]
})
export class HomepageModule { }
