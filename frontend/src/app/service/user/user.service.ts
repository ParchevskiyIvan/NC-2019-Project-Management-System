import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserModel} from "../../model/usermodel";

@Injectable({providedIn: "root"})
export class UserService {

  constructor(private http: HttpClient) {
  }


  findByEmail(email: string): any {
    return this.http.post("/api/users/email/", email);
  }


  getUsers(): Observable<UserModel[]> {
    return this.http.get<UserModel[]>('/api/users');
  }

}
