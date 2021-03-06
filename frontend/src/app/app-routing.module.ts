import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TableComponent} from "./module/main-page/components/table/table.component";
import {LoginBoxComponent} from "./module/login-page/components/login-box/login-box.component";
import {TaskPageComponent} from "./module/task-page/task-page.component";

const routes: Routes = [
  {path: '', component: LoginBoxComponent},
  {path: 'main', component: TableComponent},
  {path: 'task/:taskId', component: TaskPageComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
