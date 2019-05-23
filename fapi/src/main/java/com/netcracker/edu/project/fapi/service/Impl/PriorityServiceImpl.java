package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.PriorityModel;
import com.netcracker.edu.project.fapi.service.PriorityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Value("http://localhost:8080/")
    private String backendUrl;

    @Override
    public List<PriorityModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        PriorityModel[] priorityResponse = restTemplate.getForObject(backendUrl + "/api/priorities", PriorityModel[].class);
        return priorityResponse == null ? Collections.emptyList() : Arrays.asList(priorityResponse);
    }

}
