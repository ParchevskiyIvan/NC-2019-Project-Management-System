import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../../../service/auth/auth.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {


  constructor(private http: HttpClient, private auth: AuthService) {
  }

  ngOnInit() {

  }


}
