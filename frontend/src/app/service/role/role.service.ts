import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RoleModel} from "../../model/rolemodel";

@Injectable({providedIn: "root"})
export class RoleService {

  constructor(private http: HttpClient) { }

  getRoles(): Observable<RoleModel[]>{
    return this.http.get<RoleModel[]>('/api/roles');
  }
}
