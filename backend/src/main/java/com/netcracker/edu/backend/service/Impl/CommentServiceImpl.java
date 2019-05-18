package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.CommentEntity;
import com.netcracker.edu.backend.repository.CommentRepository;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public Iterable<CommentEntity> findCommentsByTaskId(Integer Tasks_id){
        return this.repository.findCommentsByTaskId(Tasks_id);
    }

    @Override
    public CommentEntity saveComment(CommentEntity comment){
        return repository.save(comment);
    }
}
