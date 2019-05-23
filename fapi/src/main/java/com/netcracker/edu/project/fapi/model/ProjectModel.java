package com.netcracker.edu.project.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectModel {
    private int id;
    private String projectcode;
    private String projectdescription;


    public ProjectModel() {
    }

    public ProjectModel(int id, String projectcode, String projectdescription) {
        this.id = id;
        this.projectcode = projectcode;
        this.projectdescription = projectdescription;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

}
