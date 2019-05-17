package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    //Optional<TaskEntity> findByName(String name);
    Page<TaskEntity> findAll(Pageable pageable);
    //Page<TaskEntity> findAllByName(String name, Pageable pageable);
    TaskEntity update(TaskEntity task);
    Iterable<TaskEntity> findAll();
    Optional<TaskEntity> findById(Integer id);
    TaskEntity save(TaskEntity taskEntity);
    long count();
    Optional<TaskEntity> findTaskById(Integer id);
    Iterable<TaskEntity> findTasksByProjectId(Integer Projects_id);

}