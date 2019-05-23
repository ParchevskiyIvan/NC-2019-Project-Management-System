import {Component, OnInit} from '@angular/core';
import {TaskModel} from "../../../../model/taskmodel";
import {PriorityModel} from "../../../../model/prioritymodel";
import {UserModel} from "../../../../model/usermodel";
import {ProjectModel} from "../../../../model/projectmodel";
import {UserService} from "../../../../service/user/user.service";
import {ProjectService} from "../../../../service/project/project.service";
import {PriorityService} from "../../../../service/priority/priority.service";
import {TaskService} from "../../../../service/task/task.service";
import {AuthService} from "../../../../service/auth/auth.service";
import {StatusService} from "../../../../service/status/status.service";
import {StatusModel} from "../../../../model/statusmodel";
import {take} from "rxjs/operators";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-task-modal',
  templateUrl: './task-modal.component.html',
  styleUrls: ['./task-modal.component.css'],
  providers: [DatePipe]
})
export class TaskModalComponent implements OnInit {

  newTask: TaskModel = new TaskModel();
  priorities: PriorityModel[];
  assignees: UserModel[];
  projects: ProjectModel[];
  status: StatusModel;
  creator: UserModel;
  formControl: FormGroup;
  currentDate: Date = new Date();


  constructor(private userService: UserService, private projectService: ProjectService,
              private priorityService: PriorityService, private taskService: TaskService,
              private auth: AuthService, private statusService: StatusService, private router: Router, private fb: FormBuilder,
              private datePipe: DatePipe) {
    this.datePipe.transform(this.currentDate, 'yyyy-MM-dd')
  }

  ngOnInit() {
    if (this.auth.user == null) {
    } else {
      this.initReactForm();
      this.loadPriorities();
      this.loadProjects();
      this.loadUsers();
    }

  }

  private loadProjects(): void {
    this.projectService.getProjects().subscribe(projects => {
      this.projects = projects as ProjectModel[];
    })
  }

  private loadUsers(): void {
    this.userService.getUsers().subscribe(assignees => {
      this.assignees = assignees as UserModel[];
    })
  }

  private loadPriorities(): void {
    this.priorityService.getPriority().subscribe(priorities => {
      this.priorities = priorities as PriorityModel[];
    })
  }

  initReactForm(): void {
    this.formControl = this.fb.group({
      projectcode: ['', Validators.required],
      description: ['', Validators.required],
      date: ['', Validators.required],
      estimation: ['', Validators.compose([
        Validators.required,
        Validators.pattern('[0-9]{1,2}')])],
      priority: ['', Validators.required],
      assignee: []
    });
  }


  public saveTask() {
    this.newTask.creationdate = new Date();
    this.newTask.updatedate = new Date();
    this.newTask.creator = this.auth.user;
    if (this.newTask.assignee == null) {
      this.newTask.assignee = this.auth.user
    }
    this.statusService.findByStatus("Opened").pipe(take(1)).subscribe((stat) => {
      this.newTask.status = stat;
      this.taskService.saveTask(this.newTask).subscribe(() => {
        this.newTask = new TaskModel();
      })
    })
  }

  public clearForm(): void {
    this.newTask.project = null;
    this.newTask.description = '';
    this.newTask.duedate = null;
    this.newTask.estimation = null;
    this.newTask.priority = null;
    this.newTask.assignee = null;

  }

  public reload(): void {
    this.loadUsers();
    this.loadProjects()
  }


}
