import {Component, OnInit} from '@angular/core';
import {TaskModel} from "../../model/taskmodel";
import {AuthService} from "../../service/auth/auth.service";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskService} from "../../service/task/task.service";
import {ProjectService} from "../../service/project/project.service";
import {PriorityService} from "../../service/priority/priority.service";
import {PriorityModel} from "../../model/prioritymodel";
import {StatusService} from "../../service/status/status.service";
import {StatusModel} from "../../model/statusmodel";
import {UserService} from "../../service/user/user.service";
import {UserModel} from "../../model/usermodel";
import {take} from "rxjs/operators";

@Component({
  selector: 'app-task-page',
  templateUrl: './task-page.component.html',
  styleUrls: ['./task-page.component.css']
})
export class TaskPageComponent implements OnInit {


  public task: TaskModel;
  taskId: string;
  public editMode = false;
  priorities: PriorityModel[];
  statuses: StatusModel[];
  users: UserModel[];
  status: StatusModel;

  constructor(private auth: AuthService, private http: HttpClient, private router: Router,
              private taskService: TaskService, private activatedRoute: ActivatedRoute,
              private priorityService: PriorityService, private statusService: StatusService, private userService: UserService) {
  }

  ngOnInit() {
    this.loadTask();
    this.loadPriorities();
    this.loadStatuses();
    this.loadUsers();
  }

  private getId(): void {
    this.activatedRoute.params.subscribe(params => {
      this.taskId = params['taskId'];
    });
  }

  private loadTask(): void {
    this.getId();
    this.taskService.getTaskById(this.taskId).subscribe(task => {
      this.task = task as TaskModel;
    });
  }

  private loadPriorities(): void {
    this.priorityService.getPriority().subscribe(priorities => {
      this.priorities = priorities as PriorityModel[];
    })
  }

  private loadStatuses(): void {
    this.statusService.getStatus().subscribe(statuses => {
      this.statuses = statuses as StatusModel[];
    })
  }

  private loadUsers(): void {
    this.userService.getUsers().subscribe(users => {
      this.users = users as UserModel[];
    })
  }

  private updateAssignee(){
    this.task.assignee = this.auth.user;
    this.taskService.updateTask(this.task).subscribe(
      task => {
        this.task = task;
      },
    );
  }

  private updateTaskStatus(status: string) {
    this.statusService.findByStatus(status).pipe(take(1)).subscribe((stat) => {
      this.task.status = stat;
      this.task.updatedate = new Date();
      if(status == "Resolved")
      {
        this.task.resolvedate = new Date();
      }
      else if(status == "Closed")
      {this.task.closeddate = new Date();}

      this.taskService.updateTask(this.task).subscribe(
        task => {
          this.task = task;
        },
      );
    });
  }

  private updateTask() {
    this.task.updatedate = new Date();
    this.taskService.updateTask(this.task).subscribe(
      task => {
        this.task = task;
      },
    );
  }

  private activateEditMode() {
    if (this.editMode == false) {
      this.editMode = true;
    } else {
      this.updateTask();
      this.editMode = false
    }
  }
}
