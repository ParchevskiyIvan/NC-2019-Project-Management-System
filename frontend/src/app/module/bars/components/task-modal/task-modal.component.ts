import { Component, OnInit } from '@angular/core';
import {TaskModel} from "../../../../model/taskmodel";
import {PriorityModel} from "../../../../model/prioritymodel";
import {UserModel} from "../../../../model/usermodel";
import {ProjectModel} from "../../../../model/projectmodel";
import {UserService} from "../../../../service/user/user.service";
import {ProjectService} from "../../../../service/project/project.service";
import {PriorityService} from "../../../../service/priority/priority.service";
import {TaskService} from "../../../../service/task/task.service";
import {RoleModel} from "../../../../model/rolemodel";
import {AuthService} from "../../../../service/auth/auth.service";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {StatusService} from "../../../../service/status/status.service";
import {StatusModel} from "../../../../model/statusmodel";
import {take} from "rxjs/operators";

@Component({
  selector: 'app-task-modal',
  templateUrl: './task-modal.component.html',
  styleUrls: ['./task-modal.component.css']
})
export class TaskModalComponent implements OnInit {

  newTask: TaskModel = new TaskModel();
  priorities: PriorityModel[];
  assignees: UserModel[];
  projects: ProjectModel[];
  status: StatusModel;
  creator: UserModel;


  constructor(private userService: UserService, private projectService: ProjectService,
              private priorityService: PriorityService, private taskService: TaskService,
              private auth: AuthService, private statusService: StatusService) {
  }

  ngOnInit() {
    this.projectService.getProjects().subscribe(projects => {
      this.projects = projects as ProjectModel[];
    })
    this.userService.getUsers().subscribe(assignees => {
      this.assignees = assignees as UserModel[];
    })
    this.priorityService.getPriority().subscribe(priorities => {
      this.priorities = priorities as PriorityModel[];
    })

  }

  public saveTask() {
    this.newTask.creationdate = new Date();
    this.newTask.updatedate = new Date();
    this.newTask.creator = this.auth.user;
    if(this.newTask.assignee == null){
      this.newTask.assignee = this.auth.user
    }
    this.statusService.findByStatus("Opened").pipe(take(1)).subscribe((stat) => {
      this.newTask.status = stat;
      this.taskService.saveTask(this.newTask).subscribe(() => {
        this.newTask = new TaskModel();
      })
    })
  }
}
