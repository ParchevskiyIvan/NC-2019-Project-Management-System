package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.UserEntity;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByName(String name) { return userRepository.findByName(name);}

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findUserById(Integer id) {
        return userRepository.findById(id);
    }

}