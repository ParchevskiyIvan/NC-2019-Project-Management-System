import {UserModel} from "./usermodel";
import {StatusModel} from "./statusmodel";
import {PriorityModel} from "./prioritymodel";
import {ProjectModel} from "./projectmodel";

export class TaskModel {
  id: string;
  code: string;
  creationdate: Date;
  updatedate: Date;
  duedate: Date;
  resolvedate: Date;
  closeddate: Date;
  estimation: number;
  description: string;
  project: ProjectModel;
  priority: PriorityModel;
  creator: UserModel;
  assignee: UserModel;
  status: StatusModel;

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
