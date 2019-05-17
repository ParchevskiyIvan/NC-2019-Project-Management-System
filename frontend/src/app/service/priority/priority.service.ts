import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PriorityModel} from "../../model/prioritymodel";

@Injectable({providedIn: "root"})
export class PriorityService {

  constructor(private http: HttpClient) { }

  getPriority(): Observable<PriorityModel[]>{
    return this.http.get<PriorityModel[]>("/api/priorities");
  }
}
