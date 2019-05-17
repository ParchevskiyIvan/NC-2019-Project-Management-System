package com.netcracker.edu.project.fapi.model;

import java.util.List;

public class TaskPageModel {

    private List<TaskModel> content;
    private int totalPages;
    private int numberOfElements;
    private int size;
    private int totalElements;


    public TaskPageModel() {
    }

    public List<TaskModel> getContent() {
        return content;
    }

    public void setContent(List<TaskModel> content) {
        this.content = content;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
