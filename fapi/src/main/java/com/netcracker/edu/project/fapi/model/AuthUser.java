package com.netcracker.edu.project.fapi.model;

import com.netcracker.edu.project.fapi.model.RoleModel;

public class AuthUser {
    private int id;
    private String name;
    private String email;
    private RoleModel role;

    public AuthUser() {
    }

    public AuthUser(int id, String name, String email, RoleModel role) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

}