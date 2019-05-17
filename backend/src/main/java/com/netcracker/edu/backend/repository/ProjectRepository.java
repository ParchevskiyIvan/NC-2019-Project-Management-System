package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {
    ProjectEntity findProjectById(Integer id);
}
