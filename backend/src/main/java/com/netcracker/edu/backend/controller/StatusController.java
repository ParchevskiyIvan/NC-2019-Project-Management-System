package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.StatusEntity;
import com.netcracker.edu.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<StatusEntity> getAllStatus() {
        return statusService.getAllStatus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserByID(@PathVariable(name = "id") Integer id) {
        Optional<StatusEntity> status = statusService.findStatusById(id);
        if (status.isPresent()) {
            return ResponseEntity.ok(status.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<StatusEntity> findByStatus(@PathVariable(name = "status") String status) {
        StatusEntity statusEntity = statusService.findByStatus(status);
        return ResponseEntity.ok(statusEntity);
    }
}
