import {RoleModel} from "./rolemodel";

export class AuthUserModel {
  id: string;
  name: string;
  surname: string;
  email: string;
  role: RoleModel;

  static cloneBase(user: AuthUserModel): AuthUserModel {
    const cloneUserModel: AuthUserModel = new AuthUserModel();
    cloneUserModel.id = user.id;
    cloneUserModel.email = user.email;
    cloneUserModel.name = user.name;
    cloneUserModel.surname = user.surname;
    cloneUserModel.role = user.role;
    return cloneUserModel;
  }


}

export class UserWithPassword{
  password:string;
  name:string;
  surname:string;
  role:string;
  email:string;
}
