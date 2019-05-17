export class StatusModel {
  id: string;
  status: string;

  static cloneBase(status: StatusModel): StatusModel {
    const clonedStatusModel: StatusModel = new StatusModel();
    clonedStatusModel.id = status.id;
    clonedStatusModel.status = status.status;
    return clonedStatusModel;
  }
}
