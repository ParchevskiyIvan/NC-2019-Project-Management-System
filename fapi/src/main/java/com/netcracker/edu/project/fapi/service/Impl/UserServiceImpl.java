package com.netcracker.edu.project.fapi.service.Impl;

import com.netcracker.edu.project.fapi.model.UserModel;
import com.netcracker.edu.project.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Override
    public UserModel saveUser(UserModel userModel) {
        RestTemplate restTemplate = new RestTemplate();
        userModel.setPassword(bCrypt.encode(userModel.getPassword()));
        return restTemplate.postForEntity(backendServerUrl + "/api/users", userModel, UserModel.class).getBody();
    }

    @Override
    public UserModel findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        UserModel userModel = restTemplate.getForObject(backendServerUrl + "/api/users/name/" + name, UserModel.class);
        return userModel;
    }

    @Override
    public UserModel findByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        UserModel userModel = restTemplate.getForObject(backendServerUrl + "/api/users/email/" + email, UserModel.class);
        return userModel;
    }

    @Override
    public List<UserModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserModel[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users", UserModel[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user = findByEmail(s);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserModel user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }

    @Override
    public UserModel getUserById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/" + id, UserModel.class);
    }
}