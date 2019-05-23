import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TaskModel} from "../../model/taskmodel";
import {TaskPage} from "../../model/taskpage";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) {
  }

  saveTask(task: TaskModel): Observable<TaskModel> {
    return this.http.post<TaskModel>("/api/tasks", task);
  }

  getTaskById(id: string): Observable<TaskModel> {
    return this.http.get<TaskModel>('/api/tasks/' + id);
  }

  getTaskPage(page: number, size: number, sort: string, filter: string, logid: string): Observable<TaskPage> {
    return this.http.get<TaskPage>('/api/tasks?page=' + page + '&size=' + size + '&sort=' + sort + '&filter=' + filter +
    '&logid=' + logid);
  }

  updateTask(task: TaskModel): Observable<TaskModel> {
    return this.http.patch<TaskModel>('api/tasks', task);
  }


}
