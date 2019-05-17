package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.RoleModel;
import com.netcracker.edu.project.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<RoleModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        RoleModel[] roles = restTemplate.getForObject(backendServerUrl + "/api/roles",
                RoleModel[].class);
        return roles == null ? Collections.emptyList() : Arrays.asList(roles);
    }
}
