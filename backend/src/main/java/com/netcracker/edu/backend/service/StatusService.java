package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.StatusEntity;

import java.util.Optional;

public interface StatusService {
    Iterable<StatusEntity> getAllStatus();
    Optional<StatusEntity> findStatusById(Integer id);
    StatusEntity findByStatus (String status);
}
