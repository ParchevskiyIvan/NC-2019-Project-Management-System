package com.netcracker.edu.project.fapi.service;

import com.netcracker.edu.project.fapi.model.CommentModel;

import java.util.List;

public interface CommentService {
    List<CommentModel> findCommentsByTaskId(Integer id);
    CommentModel saveComment(CommentModel comment);
}
