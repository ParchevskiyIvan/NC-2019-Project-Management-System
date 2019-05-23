package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<TaskEntity> findAll() {
        return this.repository.findAll();
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        return this.repository.save(task);
    }


    @Override
    public Optional<TaskEntity> findById(Integer id) {
        return this.repository.findById(id);
    }


    @Override
    public Page<TaskEntity> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }


    @Override
    public Iterable<TaskEntity> findTasksByProjectId(Integer Projects_id) {
        return this.repository.findTasksByProjectId(Projects_id);
    }

    @Override
    public Page<TaskEntity> findTasksByAssigneeId(Integer Assignee_id1, Pageable pageable) {
        return this.repository.findTasksByAssigneeId(Assignee_id1, pageable);
    }

    @Override
    public Page<TaskEntity> findTasksByStatusId(Integer Status_id, Pageable pageable) {
        return this.repository.findTasksByStatusId(Status_id, pageable);
    }

    @Override
    public Page<TaskEntity> findTasksByAssigneeIdAndStatusId(Integer Assignee_id1, Integer Status_id, Pageable pageable) {
        return this.repository.findTasksByAssigneeIdAndStatusId(Assignee_id1, Status_id, pageable);
    }
}
