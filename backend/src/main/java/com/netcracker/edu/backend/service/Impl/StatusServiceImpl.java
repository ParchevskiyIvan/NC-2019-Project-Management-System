package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.StatusEntity;
import com.netcracker.edu.backend.repository.StatusRepository;
import com.netcracker.edu.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Iterable<StatusEntity> getAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<StatusEntity> findStatusById(Integer id) {
        return statusRepository.findById(id);
    }

    @Override
    public StatusEntity findByStatus(String status) { return statusRepository.findByStatus(status);}
}
