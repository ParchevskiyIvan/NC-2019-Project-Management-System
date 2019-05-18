package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.CommentModel;
import com.netcracker.edu.project.fapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;


    @GetMapping("/taskId/{id}")
    public List<CommentModel> findCommentsByTaskId(@PathVariable int id){
        return commentService.findCommentsByTaskId(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CommentModel saveProject(@RequestBody CommentModel commentModel){
        return commentService.saveComment(commentModel);
    }
}
