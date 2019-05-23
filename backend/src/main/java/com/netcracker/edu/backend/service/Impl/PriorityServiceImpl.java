package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.PriorityEntity;
import com.netcracker.edu.backend.repository.PriorityRepository;
import com.netcracker.edu.backend.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public Iterable<PriorityEntity> getAllPriority() {
        return priorityRepository.findAll();
    }
}
