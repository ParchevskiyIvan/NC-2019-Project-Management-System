package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.PriorityEntity;
import com.netcracker.edu.backend.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PriorityEntity> getAllPriority() {
        return priorityService.getAllPriority();
    }
}
