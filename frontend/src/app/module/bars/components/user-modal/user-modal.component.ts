import {Component, OnInit} from '@angular/core';
import {RoleModel} from "../../../../model/rolemodel";
import {RoleService} from "../../../../service/role/role.service";
import {UserModel} from "../../../../model/usermodel";
import {UserService} from "../../../../service/user/user.service";
import {AuthService} from "../../../../service/auth/auth.service";

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css'],
})
export class UserModalComponent implements OnInit {

  newUser: UserModel = new UserModel();
  public roles: RoleModel[];
  public userExistsByEmail: boolean = false;
  public userExistsByName: boolean = false;

  constructor(private roleService: RoleService, private userService: UserService, private auth: AuthService) {
  }

  ngOnInit() {
    this.roleService.getRoles().subscribe(roles => {
      this.roles = roles as RoleModel[];
    })
  }

  private saveUser() {
    if (!this.userExistsByEmail && !this.userExistsByName) {
      this.auth.registerUser(this.newUser);
    }
  }

  public ifExistsByEmail(email: string):void{
    if(email != undefined) this.userService.findByEmail(email).subscribe((exists)=>{
      if(exists) {
        this.userExistsByEmail = true;
      }
    });
  }

  public ifExistsByName(name: string):void{
    if(name != undefined) this.userService.findByName(name).subscribe((exists)=>{
      if(exists) {
        this.userExistsByName = true;
      }
    })
  }

}
