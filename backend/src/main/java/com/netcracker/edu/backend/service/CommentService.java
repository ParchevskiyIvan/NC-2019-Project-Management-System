package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.CommentEntity;

public interface CommentService {
    Iterable<CommentEntity> findCommentsByTaskId(Integer Tasks_id);

    CommentEntity saveComment(CommentEntity comment);
}
