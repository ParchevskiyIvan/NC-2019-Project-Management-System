import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {StatusModel} from "../../model/statusmodel";
import {Observable} from "rxjs";

@Injectable({providedIn: "root"})
export class StatusService {

  constructor(private http: HttpClient) {
  }

  getStatus(): Observable<StatusModel[]> {
    return this.http.get<StatusModel[]>('/api/status');
  }

  findByStatus(status: string): Observable<StatusModel> {
    return this.http.get<StatusModel>("/api/status/status/" + status);
  }

}
