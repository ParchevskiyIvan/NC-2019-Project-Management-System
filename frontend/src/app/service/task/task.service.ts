import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ProjectModel} from "../../model/projectmodel";
import {Observable} from "rxjs";
import {PageForTasksTable, TaskModel} from "../../model/taskmodel";
import {TaskPage} from "../../model/taskpage";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }



  saveTask(task: TaskModel): Observable<TaskModel>{
    return this.http.post<TaskModel>("/api/tasks", task);
  }

  getTasks(): Observable<TaskModel[]> {
    return this.http.get<TaskModel[]>('/api/tasks');
  }

  getTaskById(id: string): Observable<TaskModel> {
    return this.http.get<TaskModel>('/api/tasks/' + id);
  }

  getTaskPage(page: number, size: number): Observable<TaskPage> {
    return this.http.get<TaskPage>('/api/tasks?page=' + page + '&size=' + size);
  }

  updateTask(task:TaskModel):Observable<TaskModel>{
    return this.http.patch<TaskModel>('api/tasks',task);
  }


}
