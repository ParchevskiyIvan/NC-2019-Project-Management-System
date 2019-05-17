package com.netcracker.edu.project.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskModel {


    private int id;
    //private String name;
    private String code;
    private LocalDate creationdate;
    private LocalDate updatedate;
    private LocalDate duedate;
    private LocalDate resolvedate;
    private LocalDate closeddate;
    private int estimation;
    //private String shortdescription;
    private String description;
    //private byte[] attachments;
    private ProjectModel project;
    private PriorityModel priority;
    private UserModel assignee;
    private StatusModel status;
    private UserModel creator;

    public TaskModel() {
    }

    public TaskModel(int id, String code, LocalDate creationdate, LocalDate updatedate, LocalDate duedate,LocalDate resolvedate,LocalDate closeddate, int estimation,
    String description, ProjectModel project, PriorityModel priority, UserModel assignee,StatusModel status, UserModel creator)
    {
        this.id = id;
        this.code = code;
        this.creationdate = creationdate;
        this.updatedate = updatedate;
        this.duedate =duedate;
        this.resolvedate = resolvedate;
        this.closeddate = closeddate;
        this.estimation = estimation;
        this.description =description;
        this.project = project;
        this.priority = priority;
        this.assignee =assignee;
        this.status = status;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {
        this.creationdate = creationdate;
    }

    public LocalDate getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(LocalDate updatedate) {
        this.updatedate = updatedate;
    }

    public LocalDate getResolvedate() {
        return resolvedate;
    }

    public void setResolvedate(LocalDate resolvedate) {
        this.resolvedate = resolvedate;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public LocalDate getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(LocalDate closeddate) {
        this.closeddate = closeddate;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectModel getProject() {
        return project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public PriorityModel getPriority() {
        return priority;
    }

    public void setPriority(PriorityModel priority) {
        this.priority = priority;
    }

    public UserModel getCreator() {
        return creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }

    public UserModel getAssignee() {
        return assignee;
    }

    public void setAssignee(UserModel assignee) {
        this.assignee = assignee;
    }

    public StatusModel getStatus() {
        return status;
    }

    public void setStatus(StatusModel status) {
        this.status = status;
    }
}
