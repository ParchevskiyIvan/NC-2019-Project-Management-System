package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.ProjectEntity;
import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.repository.ProjectRepository;
import com.netcracker.edu.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Iterable<ProjectEntity> getAllProjects(){
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity saveProject(ProjectEntity project){
        return projectRepository.save(project);
    }

    @Override
    public ProjectEntity findProjectById(Integer id) {
        return projectRepository.findProjectById(id);
    }


}
