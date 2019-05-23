import {Component, OnInit} from '@angular/core';
import {RoleModel} from "../../../../model/rolemodel";
import {RoleService} from "../../../../service/role/role.service";
import {UserModel} from "../../../../model/usermodel";
import {UserService} from "../../../../service/user/user.service";
import {AuthService} from "../../../../service/auth/auth.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css'],
})
export class UserModalComponent implements OnInit {

  newUser: UserModel = new UserModel();
  public roles: RoleModel[];
  public userExistsByEmail: boolean = false;
  public notification: boolean = false;
  public users: UserModel[];
  formControl: FormGroup;

  constructor(private roleService: RoleService, private userService: UserService, private auth: AuthService,
              private router: Router, private fb: FormBuilder) {
  }

  ngOnInit() {
    if (this.auth.user == null) {
    } else {
      this.loadRoles();
      this.loadUsers();
      this.initReactForm();
    }
  }

  initReactForm(): void {
    this.formControl = this.fb.group({
      name: ['', Validators.compose([
        Validators.required,
        Validators.pattern('[A-Za-z]+')])],
      surname: ['', Validators.compose([
        Validators.required,
        Validators.pattern('[A-Za-z]+')])],
      email: ['', Validators.compose([
        Validators.required,
        Validators.pattern('[a-zA-Z0-9_]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,4}')])],
      password: ['', Validators.compose([
        Validators.required,
        Validators.pattern('[A-Za-z0-9]+')])],
      role: ['', Validators.required]
    });
  }

  private loadRoles(): void {
    this.roleService.getRoles().subscribe(roles => {
      this.roles = roles as RoleModel[];
    })
  }


  private loadUsers(): void {
    this.userService.getUsers().subscribe(users => {
      this.users = users as UserModel[];
    })
  }

  private register() {
    this.auth.registerUser(this.newUser);
  }

  public ifExistsByEmail(email: string): void {
    this.userService.findByEmail(email).subscribe((exists) => {
      if (exists) {
        this.userExistsByEmail = true;
      } else {
        this.userExistsByEmail = false
      }
      if (!this.userExistsByEmail) {
        this.register();
        this.newUser.name = '';
        this.newUser.surname = '';
        this.newUser.email = '';
        this.newUser.role = null;
        this.newUser.password = '';

        this.notification = false;
      } else {
        this.notification = true
      }

    });
  }

  public clearForm(): void {
    this.newUser.name = '';
    this.newUser.surname = '';
    this.newUser.email = '';
    this.newUser.role = null;
    this.newUser.password = '';
    this.notification = false;
  }


}
