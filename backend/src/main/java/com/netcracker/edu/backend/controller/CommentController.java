package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.CommentEntity;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/taskId/{id}", method = RequestMethod.GET)
    public Iterable<CommentEntity> findCommentsByTaskId(@PathVariable(name = "id") Integer id) {
        Iterable<CommentEntity> tasks = commentService.findCommentsByTaskId(id);

        return tasks;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CommentEntity saveProject(@RequestBody CommentEntity comment) {
        return commentService.saveComment(comment);

    }
}
