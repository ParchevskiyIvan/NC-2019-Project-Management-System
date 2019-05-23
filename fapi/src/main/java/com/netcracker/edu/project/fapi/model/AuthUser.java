package com.netcracker.edu.project.fapi.model;


public class AuthUser {
    private int id;
    private String name;
    private String surname;
    private String email;
    private RoleModel role;

    public AuthUser() {
    }

    public AuthUser(int id, String name, String surname, String email, RoleModel role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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