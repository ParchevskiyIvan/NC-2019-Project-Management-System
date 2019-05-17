import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../model/usermodel";
import {RoleModel} from "../../../../model/rolemodel";
import {RoleService} from "../../../../service/role/role.service";
import {UserService} from "../../../../service/user/user.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../service/auth/auth.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {


  constructor(private http: HttpClient, private auth: AuthService) { }

  ngOnInit() {

  }



}
