import {Component, OnInit} from '@angular/core';
import {TaskService} from "../../../../service/task/task.service";
import {TaskPage} from "../../../../model/taskpage";
import {TaskModel} from "../../../../model/taskmodel";
import {Router} from "@angular/router";
import {AuthService} from "../../../../service/auth/auth.service";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {


  public task: TaskPage;
  public tasks: TaskModel[];
  public page = 0;
  public pageSize: number = 6;
  public totalPages: number;

  constructor(private taskService: TaskService, private router: Router, private auth: AuthService) {
  }

  ngOnInit() {
    if(this.auth.user == null){
      this.router.navigate(['']);
    }
    else{
    this.loadTasks();}
  }

  public loadTasks(): void {
    this.taskService.getTaskPage(this.page, this.pageSize).subscribe(task => {
      this.tasks = task['content'];
      this.totalPages = task['totalPages'];
    })
  }

  public goFirst(): void {
    this.page = 0;
    this.loadTasks();
  }

  public goLast(): void {
    this.page = this.totalPages - 1;
    this.loadTasks();
  }

  public goNext(): void {
    this.page = this.page + 1;
    this.loadTasks();
  }

  public goPrevious(): void {
    this.page = this.page - 1;
    this.loadTasks();
  }

}

