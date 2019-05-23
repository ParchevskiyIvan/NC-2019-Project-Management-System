package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    public ResponseEntity<ProjectEntity> findByCode(@PathVariable(name = "code") String code) {
        ProjectEntity projectEntity = projectService.findByCode(code);
        return ResponseEntity.ok(projectEntity);
    }
}
