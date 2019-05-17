export class RoleModel {
  public id: string;
  public role: string;

  static cloneBase(role: RoleModel):RoleModel{
    const cloneRoleModel: RoleModel = new RoleModel();
    cloneRoleModel.id = role.id;
    cloneRoleModel.role = role.role;
    return cloneRoleModel;
  }

}
