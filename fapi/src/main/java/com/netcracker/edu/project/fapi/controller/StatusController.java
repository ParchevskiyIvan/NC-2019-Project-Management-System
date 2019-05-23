package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.StatusModel;
import com.netcracker.edu.project.fapi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusModel>> getAllStatus() {
        return ResponseEntity.ok(statusService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusModel> getStatusById(@PathVariable int id) {
        return ResponseEntity.ok(statusService.getStatusById(id));
    }

    @GetMapping("/status/{status}")
    public StatusModel getStatusByStatus(@PathVariable String status) {
        return statusService.findByStatus(status);
    }
}
