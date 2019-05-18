import {TaskModel} from "./taskmodel";
import {UserModel} from "./usermodel";

export class CommentModel {
  public id: string;
  public comment: string;
  public task: TaskModel;
  public user: UserModel;

  static cloneBase(comment: CommentModel):CommentModel{
    const cloneCommentModel: CommentModel = new CommentModel();
    cloneCommentModel.id = comment.id;
    cloneCommentModel.comment = comment.comment;
    cloneCommentModel.task = comment.task;
    cloneCommentModel.user = comment.user;
    return cloneCommentModel;
  }

}
