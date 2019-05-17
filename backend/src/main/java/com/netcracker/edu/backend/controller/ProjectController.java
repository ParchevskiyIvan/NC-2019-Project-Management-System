package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ProjectEntity> getAllProjects() {
        return projectService.getAllProjects();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProjectEntity saveProject(@RequestBody ProjectEntity project) {
        return projectService.saveProject(project);

    }
}
