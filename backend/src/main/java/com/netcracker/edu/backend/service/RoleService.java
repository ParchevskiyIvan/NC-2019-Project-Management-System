package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleEntity> findAll();

    Optional<RoleEntity> getRoleById(Integer id);
}
