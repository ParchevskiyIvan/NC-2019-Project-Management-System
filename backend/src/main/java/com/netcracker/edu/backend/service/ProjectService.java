package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProjectEntity;

import java.util.Optional;

public interface ProjectService {
    Iterable<ProjectEntity> getAllProjects();
    ProjectEntity saveProject(ProjectEntity project);
    ProjectEntity findProjectById(Integer id);
}
