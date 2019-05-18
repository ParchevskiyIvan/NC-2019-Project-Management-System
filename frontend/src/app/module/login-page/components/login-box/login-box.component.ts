import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../../../../service/auth/auth.service";
import {UserModel} from "../../../../model/usermodel";
import {UserService} from "../../../../service/user/user.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css']
})
export class LoginBoxComponent implements OnInit {

  public userExistsByEmail: boolean = false;
  user: UserModel = new UserModel();

  constructor(private http: HttpClient, private router: Router, private auth: AuthService, private userService: UserService) {

  }

  public onSubmit(): void{
    this.auth.signIn(this.user);
  }

  public ifExistsByEmail(email: string):void{
    if(email != undefined) this.userService.findByEmail(email).subscribe((exists)=>{
      if(exists) {
        this.userExistsByEmail = true;
      }
    });
  }

  ngOnInit() {
  }

}
