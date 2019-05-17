package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<StatusEntity, Integer> {
    StatusEntity findByStatus(String status);
}
