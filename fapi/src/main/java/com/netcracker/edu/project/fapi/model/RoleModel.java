package com.netcracker.edu.project.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleModel {

    private int id;
    private String role;

    public RoleModel(){
    }

    public RoleModel(int id, String role){
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
