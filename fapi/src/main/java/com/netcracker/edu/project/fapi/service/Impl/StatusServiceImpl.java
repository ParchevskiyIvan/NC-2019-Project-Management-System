package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.StatusModel;
import com.netcracker.edu.project.fapi.service.StatusService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<StatusModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        StatusModel[] statusResponse = restTemplate.getForObject(backendServerUrl + "/api/status",
                StatusModel[].class);
        return statusResponse == null ? Collections.emptyList() : Arrays.asList(statusResponse);
    }

    @Override
    public StatusModel findByStatus(String status) {
        RestTemplate restTemplate = new RestTemplate();
        StatusModel statusModel = restTemplate.getForObject(backendServerUrl + "/api/status/status/" + status, StatusModel.class);
        return statusModel;
    }

    @Override
    public StatusModel getStatusById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/status/" + id, StatusModel.class);
    }

}
