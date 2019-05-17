package com.netcracker.edu.project.fapi.service;

import com.netcracker.edu.project.fapi.model.ProjectModel;

import java.util.List;

public interface ProjectService {
    ProjectModel saveProject(ProjectModel project);
    List<ProjectModel> findAll();
    ProjectModel getProjectById(Integer id);
    ProjectModel getProjectByCode(String code);
}
