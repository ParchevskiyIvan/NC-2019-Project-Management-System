import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserModel} from "../../model/usermodel";

@Injectable({providedIn: "root"})
export class UserService {

  constructor(private http: HttpClient) { }

  saveUser(user: UserModel): Observable<UserModel>{
    return this.http.post<UserModel>("/api/users/", user);
  }

  findByEmail(email:string): any{
    return this.http.get("/api/users/email/" + email);
  }

  findByName(name : string): any{
    return this.http.get("/api/users/name/" + name);
  }

  getUsers(): Observable<UserModel[]>{
    return this.http.get<UserModel[]>('/api/users');
  }

  getUserById(id:string):Observable<UserModel>{
    return this.http.get<UserModel>('api/users/'+id);
  }
}
