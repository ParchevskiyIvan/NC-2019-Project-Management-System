import {RoleModel} from "./rolemodel";

export class UserModel {
  id: string;
  name: string;
  email: string;
  password?: string;
  role: RoleModel;

  static cloneBase(user: UserModel):UserModel{
    const cloneUserModel: UserModel = new UserModel();
    cloneUserModel.id = user.id;
    cloneUserModel.name = user.name;
    cloneUserModel.email = user.email;
    cloneUserModel.password = user.password;
    cloneUserModel.role = user.role;
    return cloneUserModel;
  }
}

export class AuthToken{
  token:string;
}
