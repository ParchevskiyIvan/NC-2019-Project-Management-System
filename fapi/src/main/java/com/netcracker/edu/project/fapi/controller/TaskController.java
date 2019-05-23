package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.PageModel;
import com.netcracker.edu.project.fapi.model.TaskModel;
import com.netcracker.edu.project.fapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public TaskModel saveTask(@RequestBody TaskModel taskModel) {
        return taskService.saveTask(taskModel);
    }

    @PatchMapping("")
    public TaskModel updateTask(@RequestBody TaskModel taskModel) {
        {
            return taskService.saveTask(taskModel);
        }

    }

    @RequestMapping("")
    public List<TaskModel> getTasks() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<PageModel> getAllProducts(@RequestParam(value = "page") int page,
                                                    @RequestParam(value = "size") int size,
                                                    @RequestParam(value = "sort") String sort,
                                                    @RequestParam(value = "filter") String filter,
                                                    @RequestParam(value = "logid") String logid) {
        PageModel task = taskService.getPage(page, size, sort, filter, logid);
        if (task.getContent() != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
