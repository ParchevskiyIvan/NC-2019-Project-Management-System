package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findByEmail(@PathVariable(name = "email") String email) {
        UserEntity userEntity = userService.findByEmail(email);
        return ResponseEntity.ok(userEntity);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> findByName(@PathVariable(name = "name") String name) {
        UserEntity userEntity = userService.findByName(name);
        return ResponseEntity.ok(userEntity);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserByID(@PathVariable(name = "id") Integer id) {
        Optional<UserEntity> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
