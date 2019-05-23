import {Component, OnInit} from '@angular/core';
import {ProjectModel} from "../../../../model/projectmodel";
import {ProjectService} from "../../../../service/project/project.service";
import {AuthService} from "../../../../service/auth/auth.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-project-modal',
  templateUrl: './project-modal.component.html',
  styleUrls: ['./project-modal.component.css']
})
export class ProjectModalComponent implements OnInit {

  newProject: ProjectModel = new ProjectModel();
  formControl: FormGroup;
  public projectExistsByCode: boolean = false;
  public notification: boolean = false;

  constructor(private projectService: ProjectService, private auth: AuthService, private fb: FormBuilder) {
  }

  ngOnInit() {
    this.initReactForm();
  }

  initReactForm(): void {
    this.formControl = this.fb.group({
      projectcode: ['', Validators.compose([
        Validators.required,
        Validators.pattern('[A-Za-z0-9]+')])],
      summary: ['', Validators.required]
    });
  }

  private saveProject() {
    this.projectService.saveProject(this.newProject).subscribe(() => {
      this.newProject = new ProjectModel();
    })
  }


  public ifExistsByCode(code: string): void {
    this.projectService.findByCode(code).subscribe((exists) => {
      if (exists) {
        this.projectExistsByCode = true;
      } else {
        this.projectExistsByCode = false
      }
      if (!this.projectExistsByCode) {
        this.saveProject();
        this.notification = false;
      } else {
        this.notification = true
      }

    });
  }

  public clearForm(): void {
    this.newProject.projectcode = '';
    this.newProject.projectdescription = '';
    this.notification = false;
  }

}
