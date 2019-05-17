package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.Impl.ProjectServiceImpl;
import com.netcracker.edu.backend.service.ProjectService;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/tasks")
public class TaskController{

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectService projectService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TaskEntity> getAllTasks(){
        return this.taskService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public TaskEntity saveTasks(@RequestBody TaskEntity task){
        ProjectEntity project = projectService.findProjectById(task.getProject().getId());
        String projectCode = project.getProjectcode();
        Iterable<TaskEntity> tasks= taskService.findTasksByProjectId(project.getId());
        List<TaskEntity> taskList = new ArrayList<TaskEntity>();
        tasks.forEach(taskList::add);

        task.setCode(projectCode + "-" + taskList.size());
        return this.taskService.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getTaskByID(@PathVariable(name = "id") Integer id){
        Optional<TaskEntity> user = taskService.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @PatchMapping("")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task){
        TaskEntity updatedTask = taskRepository.findTaskById(task.getId());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setUpdatedate(task.getUpdatedate());
        updatedTask.setDuedate(task.getDuedate());
        updatedTask.setResolvedate(task.getResolvedate());
        updatedTask.setCloseddate(task.getCloseddate());
        updatedTask.setEstimation(task.getEstimation());
        //foundTask.setTaskComments(task.getTaskComments());
        updatedTask.setCreator(task.getCreator());
        TaskEntity taskResult = taskService.save(updatedTask);

        if(taskResult==null)

            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(taskResult);
    }

    @RequestMapping(value = "", params = {"size", "page"}, method = RequestMethod.GET)
    public Page<TaskEntity> getPage(@RequestParam(value = "page") int page,
                                        @RequestParam(value = "size", defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<TaskEntity> result = taskService.findAll(pageable);
        return result;
    }

}

