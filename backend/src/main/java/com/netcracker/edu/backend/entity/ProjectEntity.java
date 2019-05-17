package com.netcracker.edu.backend.entity;//package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projects", schema = "mydb", catalog = "")
public class ProjectEntity {
    private int id;
    private String projectdescription;
    private String projectcode;
    //private int usersId;
    //private UserEntity usersByUsersId;

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
    @Column(name = "projectdescription")
    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    @Basic
    @Column(name = "projectcode")
    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

//    @Basic
//    @Column(name = "Users_id")
//    public int getUsersId() {
//        return usersId;
//    }
//
//    public void setUsersId(int usersId) {
//        this.usersId = usersId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return id == that.id &&
//                usersId == that.usersId &&
                Objects.equals(projectdescription, that.projectdescription) &&
                Objects.equals(projectcode, that.projectcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectdescription, projectcode/*, usersId*/);
    }

//    @ManyToOne
//    @JoinColumn(name = "Users_id", referencedColumnName = "id", nullable = false)
//    public UserEntity getUsersByUsersId() {
//        return usersByUsersId;
//    }
//
//    public void setUsersByUsersId(UserEntity usersByUsersId) {
//        this.usersByUsersId = usersByUsersId;
//    }
}
