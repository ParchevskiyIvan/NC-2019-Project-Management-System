package com.netcracker.edu.project.fapi.service;


import com.netcracker.edu.project.fapi.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel findByEmail(String email);
    UserModel findByName (String name);
    List<UserModel> findAll();
    UserModel saveUser(UserModel userModel);
    UserModel getUserById(int id);
}
