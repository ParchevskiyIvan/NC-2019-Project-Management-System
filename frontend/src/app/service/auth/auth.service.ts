import { Injectable } from '@angular/core';
import {AuthUserModel} from "../../model/authuser";
import {HttpClient} from "@angular/common/http";
import {AuthToken, UserModel} from "../../model/usermodel";
import {Observable} from "rxjs";
import {NavigationExtras, Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})

  export class AuthService {
  public user: AuthUserModel;
  public token: string;

  public authError: boolean = false;

  constructor(private http: HttpClient,
              private router: Router){
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if(user && token){
      this.user = user;
      this.token = token;
    }else {
      this.user = null;
      this.token = "";
    }
  }

  public getToken(user: UserModel):Observable<AuthToken>{
    return this.http.post<AuthToken>("/api/users/auth/generate-token", user);
  }

  public regNewUser(user: UserModel): Observable<AuthToken>{
    return this.http.post<AuthToken>('api/users/auth/sign-up',user);
  }

  public userAuth():Observable<UserModel>{
    return this.http.get<UserModel>("/api/users/auth/user");
  }

  public signIn(authUser: UserModel):void{
    this.getToken(authUser).subscribe(data=>{
      this.token = data.token;
      this.userAuth().subscribe(data=>{
        this.user = data;
        localStorage.setItem("user", JSON.stringify(this.user));
        localStorage.setItem("token", this.token);
        this.router.navigate(['/main']);
      }, error1 => {
        this.toErrorPage(error1);
      })
    }, error1 => {
      this.authError = true;
    })
  }

  public registerUser(authUser: UserModel):void{
    this.regNewUser(authUser).subscribe(data=>{
      //this.token = data.token;
      this.userAuth().subscribe(data=>{
        localStorage.setItem("user", JSON.stringify(data));
        localStorage.setItem("token", this.token);
        this.user = data;
        //this.router.navigate(['/main']);
      }, error => {
        this.toErrorPage(error);
      })
    }, error => {
      this.toErrorPage(error);
    })
  }

  public logOut():void{
    localStorage.clear();
    this.user = null;
    this.token = "";
    this.router.navigate(['']);
    setTimeout(location.reload.bind(location), 100);
  }

  public toErrorPage(error){
    let nav: NavigationExtras = {
      queryParams:{
        "code": error.status,
        "message": error.statusText
      }
    };
    this.router.navigate(['/error'], nav)
  }
}
