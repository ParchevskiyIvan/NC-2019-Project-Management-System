package com.netcracker.edu.project.fapi.service;

import com.netcracker.edu.project.fapi.model.PageModel;
import com.netcracker.edu.project.fapi.model.TaskModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> getAll();

    TaskModel saveTask(TaskModel task);

    TaskModel getTaskById(int id);

    PageModel getPage(int page, int size, String sort, String filter, String logid);
}
