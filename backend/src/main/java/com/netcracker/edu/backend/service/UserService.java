package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity findByEmail(String email);

    UserEntity findByName(String name);

    UserEntity saveUser(UserEntity userEntity);

    Optional<UserEntity> findUserById(Integer id);
}
