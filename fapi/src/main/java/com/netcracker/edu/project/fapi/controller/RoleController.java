package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.RoleModel;
import com.netcracker.edu.project.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("")
    public List<RoleModel> getRoles() {
        return roleService.findAll();
    }
}
