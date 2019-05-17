package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
    UserEntity findByName(String name);
}
