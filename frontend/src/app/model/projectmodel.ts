import {UserModel} from "./usermodel";

export class ProjectModel {
  id: string;
  projectcode: string;
  projectdescription: string;
  //user: UserModel;

  static cloneBase(project: ProjectModel): ProjectModel{
    const cloneProjectModel: ProjectModel = new ProjectModel();
    cloneProjectModel.id = project.id;
    cloneProjectModel.projectdescription = project.projectdescription;
    cloneProjectModel.projectcode = project.projectcode;
    //cloneProjectModel.user = project.user;
    return cloneProjectModel;
  }
}
