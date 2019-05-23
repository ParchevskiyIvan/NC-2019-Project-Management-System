package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ProjectEntity;

public interface ProjectService {
    Iterable<ProjectEntity> getAllProjects();

    ProjectEntity saveProject(ProjectEntity project);

    ProjectEntity findProjectById(Integer id);

    ProjectEntity findByCode(String projectcode);
}
