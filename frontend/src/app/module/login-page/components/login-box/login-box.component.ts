import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../../../../service/auth/auth.service";
import {UserModel} from "../../../../model/usermodel";
import {UserService} from "../../../../service/user/user.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css']
})
export class LoginBoxComponent implements OnInit {

  public existance: boolean = false;
  user: UserModel = new UserModel();
  formControl: FormGroup;

  constructor(private http: HttpClient, private router: Router, private auth: AuthService, private userService: UserService,
              private fb: FormBuilder) {

  }


  ngOnInit() {
    this.initReactForm()
  }

  initReactForm(): void {
    this.formControl = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });

  }

  public onSubmit() {
    this.auth.signIn(this.user);
  }


}
