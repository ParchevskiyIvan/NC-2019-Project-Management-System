import { Component, OnInit } from '@angular/core';
import {ProjectModel} from "../../../../model/projectmodel";
import {ProjectService} from "../../../../service/project/project.service";
import {AuthService} from "../../../../service/auth/auth.service";

@Component({
  selector: 'app-project-modal',
  templateUrl: './project-modal.component.html',
  styleUrls: ['./project-modal.component.css']
})
export class ProjectModalComponent implements OnInit {

  newProject: ProjectModel = new ProjectModel();

  constructor(private projectService: ProjectService, private auth: AuthService) { }

  ngOnInit() {
  }

  private saveProject(){
    this.projectService.saveProject(this.newProject).subscribe(()=>{
      this.newProject = new ProjectModel();
    })
  }
}
