import {RoleModel} from "./rolemodel";

export class UserModel {
  id: string;
  name: string;
  surname: string;
  email: string;
  password?: string;
  role: RoleModel;
}

export class AuthToken{
  token:string;
}
