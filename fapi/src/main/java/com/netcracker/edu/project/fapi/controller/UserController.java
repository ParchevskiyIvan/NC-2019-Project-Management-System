package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.UserModel;
import com.netcracker.edu.project.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/email")
    public ResponseEntity<Boolean> getUserByEmail(@RequestBody String email) {
        UserModel user = userService.findByEmail(email);
        if (user == null) return ResponseEntity.ok(false);
        else return ResponseEntity.ok(true);
    }

    @GetMapping("/name/{name}")
    public UserModel getUserByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}