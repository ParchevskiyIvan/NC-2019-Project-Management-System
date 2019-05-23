package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.CommentModel;
import com.netcracker.edu.project.fapi.service.CommentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<CommentModel> findCommentsByTaskId(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        CommentModel[] taskModelResponse = restTemplate.getForObject(backendServerUrl + "/api/comments/taskId/" + id, CommentModel[].class);
        return taskModelResponse == null ? Collections.emptyList() : Arrays.asList(taskModelResponse);
    }

    @Override
    public CommentModel saveComment(CommentModel comment) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/comments", comment, CommentModel.class).getBody();
    }
}
