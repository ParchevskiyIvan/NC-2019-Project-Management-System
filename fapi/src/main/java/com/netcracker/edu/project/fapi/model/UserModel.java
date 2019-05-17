package com.netcracker.edu.project.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    private int id;
    private String name;
    private String email;
    private String password;
    private RoleModel role;

    public UserModel() {
    }

    public UserModel(int id, String name, String email, String password, RoleModel role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}