package com.netcracker.edu.project.fapi.service;

import com.netcracker.edu.project.fapi.model.StatusModel;

import java.util.List;

public interface StatusService {
    List<StatusModel> findAll();

    StatusModel getStatusById(int id);

    StatusModel findByStatus(String status);
}
