package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.PageModel;
import com.netcracker.edu.project.fapi.model.TaskModel;
import com.netcracker.edu.project.fapi.service.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<TaskModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        TaskModel[] taskModelResponse = restTemplate.getForObject(backendServerUrl + "/api/tasks", TaskModel[].class);
        return taskModelResponse == null ? Collections.emptyList() : Arrays.asList(taskModelResponse);
    }


    @Override
    public TaskModel saveTask(TaskModel task) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/tasks", task, TaskModel.class).getBody();
    }

    @Override
    public TaskModel getTaskById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/tasks/" + id, TaskModel.class);
    }


    @Override
    public PageModel getPage(int page, int size, String sort, String filter, String logid) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/tasks?page=" + page
                + "&size=" + size + "&sort=" + sort + "&filter=" + filter + "&logid=" + logid, PageModel.class);
    }


}
