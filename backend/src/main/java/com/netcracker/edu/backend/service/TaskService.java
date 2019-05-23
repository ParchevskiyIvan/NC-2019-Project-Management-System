package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService {
    Page<TaskEntity> findAll(Pageable pageable);

    Iterable<TaskEntity> findAll();

    Optional<TaskEntity> findById(Integer id);

    TaskEntity save(TaskEntity taskEntity);

    Iterable<TaskEntity> findTasksByProjectId(Integer Projects_id);

    Page<TaskEntity> findTasksByAssigneeId(Integer Assignee_id1, Pageable pageable);

    Page<TaskEntity> findTasksByStatusId(Integer Status_id, Pageable pageable);

    Page<TaskEntity> findTasksByAssigneeIdAndStatusId(Integer Assignee_id1, Integer Status_id, Pageable pageable);

}