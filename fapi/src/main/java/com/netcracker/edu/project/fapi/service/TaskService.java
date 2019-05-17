package com.netcracker.edu.project.fapi.service;

import com.netcracker.edu.project.fapi.model.PageModel;
import com.netcracker.edu.project.fapi.model.TaskModel;
import com.netcracker.edu.project.fapi.model.TaskPageModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {
    List<TaskModel> getAll();
    TaskModel saveTask(TaskModel task);
    TaskModel getTaskById(int id);
    TaskModel updateTask(TaskModel task);
    PageModel getPage(int page, int size);
}
