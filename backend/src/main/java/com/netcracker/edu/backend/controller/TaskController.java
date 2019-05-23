package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.*;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.ProjectService;
import com.netcracker.edu.backend.service.StatusService;
import com.netcracker.edu.backend.service.TaskService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TaskEntity> getAllTasks() {
        return this.taskService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public TaskEntity saveTasks(@RequestBody TaskEntity task) {
        ProjectEntity project = projectService.findProjectById(task.getProject().getId());
        String projectCode = project.getProjectcode();
        Iterable<TaskEntity> tasks = taskService.findTasksByProjectId(project.getId());
        List<TaskEntity> taskList = new ArrayList<TaskEntity>();
        tasks.forEach(taskList::add);

        task.setCode(projectCode + "-" + taskList.size());
        return this.taskService.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getTaskByID(@PathVariable(name = "id") Integer id) {
        Optional<TaskEntity> user = taskService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task) {
        TaskEntity updatedTask = taskRepository.findTaskById(task.getId());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setUpdatedate(task.getUpdatedate());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDuedate(task.getDuedate());
        updatedTask.setResolvedate(task.getResolvedate());
        updatedTask.setCloseddate(task.getCloseddate());
        updatedTask.setEstimation(task.getEstimation());
        updatedTask.setAssignee(task.getAssignee());
        updatedTask.setCreator(task.getCreator());
        TaskEntity taskResult = taskService.save(updatedTask);

        if (taskResult == null)

            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskResult);
    }

    @RequestMapping(value = "", params = {"size", "page", "sort", "filter", "logid"}, method = RequestMethod.GET)
    public Page<TaskEntity> getPage(@RequestParam(value = "page") int page,
                                    @RequestParam(value = "size", defaultValue = "5") int size,
                                    @RequestParam(value = "sort") String sort,
                                    @RequestParam(value = "filter") String filter,
                                    @RequestParam(value = "logid") Integer logid) {
        Page<TaskEntity> taskPage = null;

        Optional<UserEntity> optionalUser = userService.findUserById(logid);

        UserEntity userEntity = optionalUser.get();

        RoleEntity roleEntity = userEntity.getRole();


        String role = roleEntity.getRole();

        if (sort.equals("null") && filter.equals("null")) {
            if(role.equals("Developer")){
                taskPage = taskService.findTasksByAssigneeId(logid, PageRequest.of(page, size));
            } else{
            taskPage = taskService.findAll(PageRequest.of(page, size));}
        }
        if (!sort.equals("null") && filter.equals("null")) {
            switch (sort) {
                case "urgent": {
                    if(role.equals("Developer")){
                        taskPage = taskService.findTasksByAssigneeId(logid, PageRequest.of(page, size,Sort.by("priority").ascending()));
                        break;
                    } else{
                    taskPage = taskService.findAll(PageRequest.of(page, size, Sort.by("priority").ascending()));
                    break;}
                }
                case "noturgent": {
                    if(role.equals("Developer")){
                        taskPage = taskService.findTasksByAssigneeId(logid, PageRequest.of(page, size,Sort.by("priority").descending()));
                        break;
                    } else {
                    taskPage = taskService.findAll(PageRequest.of(page, size, Sort.by("priority").descending()));
                    break;}
                }
            }
        }
        if (sort.equals("null") && !filter.equals("null")) {
//            ???
            if(role.equals("Developer"))
            {

                StatusEntity statusEntity = statusService.findByStatus(filter);
                int statusId = statusEntity.getId();
                taskPage = taskService.findTasksByAssigneeIdAndStatusId(logid, statusId, PageRequest.of(page, size));
//

            }
            else {
            StatusEntity statusEntity = statusService.findByStatus(filter);
            int statusId = statusEntity.getId();
            taskPage = taskService.findTasksByStatusId(statusId, PageRequest.of(page, size));}

        }

        if (!sort.equals("null") && !filter.equals("null")) {
            StatusEntity statusEntity = statusService.findByStatus(filter);
            int statusId = statusEntity.getId();
            switch (sort) {
                case "urgent": {
                    if(role.equals("Developer")){
                        taskPage = taskService.findTasksByAssigneeIdAndStatusId(logid,statusId, PageRequest.of(page, size, Sort.by("priority").ascending()));
                        break;
                    }
                    else{
                    taskPage = taskService.findTasksByStatusId(statusId, PageRequest.of(page, size, Sort.by("priority").ascending()));
                    break;}
                }
                case "noturgent": {
                    if(role.equals("Developer")){
                        taskPage = taskService.findTasksByAssigneeIdAndStatusId(logid,statusId, PageRequest.of(page, size, Sort.by("priority").descending()));
                        break;
                    } else {
                    taskPage = taskService.findTasksByStatusId(statusId, PageRequest.of(page, size, Sort.by("priority").descending()));
                    break;}
                }
            }
        }


        return taskPage;
    }

}

