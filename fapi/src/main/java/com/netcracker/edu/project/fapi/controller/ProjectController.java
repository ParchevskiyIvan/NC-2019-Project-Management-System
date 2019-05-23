package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.ProjectModel;
import com.netcracker.edu.project.fapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ProjectModel saveProject(@RequestBody ProjectModel projectModel) {
        return projectService.saveProject(projectModel);
    }

    @RequestMapping("")
    public List<ProjectModel> getProjects() {
        return projectService.findAll();
    }

    @PostMapping("/code")
    public ResponseEntity<Boolean> getProjectByCode(@RequestBody String code) {
        ProjectModel project = projectService.findByCode(code);
        if (project == null) return ResponseEntity.ok(false);
        else return ResponseEntity.ok(true);
    }

}