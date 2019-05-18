package com.netcracker.edu.backend.entity;//package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "mydb", catalog = "")
public class CommentEntity {
    private int id;
    private String comment;
//    private int tasksId;
//    private int usersId;
    private TaskEntity task;
    private UserEntity user;

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
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    @Basic
//    @Column(name = "Tasks_id")
//    public int getTasksId() {
//        return tasksId;
//    }
//
//    public void setTasksId(int tasksId) {
//        this.tasksId = tasksId;
//    }
//
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
        CommentEntity that = (CommentEntity) o;
        return id == that.id &&
//                tasksId == that.tasksId &&
//                usersId == that.usersId &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment/*, tasksId, usersId*/);
    }

    @ManyToOne
    @JoinColumn(name = "Tasks_id", referencedColumnName = "id", nullable = false)
    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    @ManyToOne
    @JoinColumn(name = "Users_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
