import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProjectModel} from "../../model/projectmodel";

@Injectable({providedIn: "root"})
export class ProjectService {

  constructor(private http: HttpClient) {
  }

  saveProject(project: ProjectModel): Observable<ProjectModel> {
    return this.http.post<ProjectModel>("/api/projects", project);
  }

  getProjects(): Observable<ProjectModel[]> {
    return this.http.get<ProjectModel[]>('/api/projects');
  }

  findByCode(code: string): any {
    return this.http.post("/api/projects/code/", code);
  }
}
