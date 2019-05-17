export class PriorityModel {
  id: string;
  priority: string;

  static cloneBase(priority: PriorityModel): PriorityModel{
    const clonePriorityModel: PriorityModel = new PriorityModel();
    clonePriorityModel.id = priority.id;
    clonePriorityModel.priority = priority.priority;
    return clonePriorityModel;
  }
}
