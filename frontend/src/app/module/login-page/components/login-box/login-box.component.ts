import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../../../../service/auth/auth.service";
import {UserModel} from "../../../../model/usermodel";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css']
})
export class LoginBoxComponent implements OnInit {

  user: UserModel = new UserModel();

  constructor(private http: HttpClient, private router: Router, private auth: AuthService) {

  }

  public onSubmit(): void{
    this.auth.signIn(this.user);
  }

  ngOnInit() {
  }

}
