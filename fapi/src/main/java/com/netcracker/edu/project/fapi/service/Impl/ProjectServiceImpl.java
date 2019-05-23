package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.ProjectModel;
import com.netcracker.edu.project.fapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public ProjectModel saveProject(ProjectModel project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/projects", project, ProjectModel.class).getBody();
    }

    public List<ProjectModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProjectModel[] projects = restTemplate.getForObject(backendServerUrl + "/api/projects",
                ProjectModel[].class);
        return projects == null ? Collections.emptyList() : Arrays.asList(projects);
    }


    @Override
    public ProjectModel findByCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        ProjectModel projectModel = restTemplate.getForObject(backendServerUrl + "/api/projects/code/" + code, ProjectModel.class);
        return projectModel;
    }
}
