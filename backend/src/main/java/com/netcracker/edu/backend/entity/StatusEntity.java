package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status", schema = "mydb")
public class StatusEntity {
    private int id;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "statusname")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return id == that.id &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
