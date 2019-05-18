package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
    Iterable<CommentEntity> findCommentsByTaskId(Integer Tasks_id);
}
