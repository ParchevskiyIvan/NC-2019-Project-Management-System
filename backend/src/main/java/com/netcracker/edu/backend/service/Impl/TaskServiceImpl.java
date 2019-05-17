package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.TaskEntity;
import com.netcracker.edu.backend.repository.TaskRepository;
import com.netcracker.edu.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public Iterable<TaskEntity> findAll(){
        return this.repository.findAll();
    }

    @Override
    public TaskEntity save(TaskEntity task){
        return this.repository.save(task);
    }

    @Override
    public TaskEntity update(TaskEntity task){
        Optional<TaskEntity> taskEntity = this.repository.findById(task.getId());
        return this.repository.save(taskEntity.get());
    }

    @Override
    public long count() {
        return this.repository.count();
    }

    @Override
    public Optional<TaskEntity> findById(Integer id){
        return this.repository.findById(id);
    }

//    @Override
//    public Optional<TaskEntity> findByName(String name) {
//        return this.repository.findByName(name);
//    }

    @Override
    public Page<TaskEntity> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

//    @Override
//    public Page<TaskEntity> findAllByName(String name, Pageable pageable) {
//        return this.repository.findAllByName(name, pageable);
//    }

    @Override
    public Optional<TaskEntity> findTaskById(Integer id) {
        return repository.findById(id);
    }

    public Iterable<TaskEntity> findTasksByProjectId(Integer Projects_id){
        return this.repository.findTasksByProjectId(Projects_id);
    }
}
