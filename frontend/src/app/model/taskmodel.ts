import {UserModel} from "./usermodel";
import {StatusModel} from "./statusmodel";
import {PriorityModel} from "./prioritymodel";
import {ProjectModel} from "./projectmodel";
import {AuthUserModel} from "./authuser";

export class TaskModel {
  id: string;
  //name: string;
  code: string;
  creationdate: Date;
  updatedate: Date;
  duedate: Date;
  resolvedate: Date;
  closeddate: Date;
  estimation: number;
  description: string;
  //shortdescription: string;
  project: ProjectModel;
  priority: PriorityModel;
  creator: UserModel;
  assignee: UserModel;
  status: StatusModel;



  static cloneBase(task: TaskModel) :TaskModel{
    const cloneTaskModel: TaskModel = new TaskModel();
    cloneTaskModel.id = task.id;
    //cloneTaskModel.name = task.name;
    cloneTaskModel.code = task.code;
    cloneTaskModel.duedate = task.duedate;
    cloneTaskModel.creationdate = task.creationdate;
    cloneTaskModel.updatedate = task.updatedate;
    cloneTaskModel.resolvedate = task.resolvedate;
    cloneTaskModel.closeddate = task.closeddate;
    cloneTaskModel.description = task.description;
    //cloneTaskModel.shortdescription = task.shortdescription;
    cloneTaskModel.estimation = task.estimation;
    cloneTaskModel.assignee = task.assignee;
    cloneTaskModel.creator = task.creator;
    cloneTaskModel.status = task.status;
    cloneTaskModel.priority = task.priority;
    cloneTaskModel.project = task.project;
    return cloneTaskModel;
  }
}

export class PageForTasksTable{
  content:Array<TaskModel>;
  firstPage:boolean;
  lastPage:boolean;
  number:number;
  numberOfElements:number;
  size:number;
  sort:string;
  totalElements:number;
  totalPages:number;
}
