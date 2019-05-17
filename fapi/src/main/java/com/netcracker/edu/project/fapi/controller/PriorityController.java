package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.PriorityModel;
import com.netcracker.edu.project.fapi.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;

    @GetMapping
    public ResponseEntity<List<PriorityModel>> getAllPriority(){
        return ResponseEntity.ok(priorityService.findAll());
    }
}
