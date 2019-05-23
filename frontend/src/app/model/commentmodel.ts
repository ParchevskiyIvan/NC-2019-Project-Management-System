import {TaskModel} from "./taskmodel";
import {UserModel} from "./usermodel";

export class CommentModel {
  public id: string;
  public comment: string;
  public task: TaskModel;
  public user: UserModel;
}
