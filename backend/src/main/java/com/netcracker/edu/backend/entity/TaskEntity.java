package com.netcracker.edu.backend.entity;//package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "tasks", schema = "mydb", catalog = "")
public class TaskEntity {
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
    private ProjectEntity project;
    private PriorityEntity priority;
    private UserEntity creator;
    private UserEntity assignee;
    private StatusEntity status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Basic
    @Column(name = "taskcode")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Basic
    @Column(name = "creationdate")
    public LocalDate getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {
        this.creationdate = creationdate;
    }

    @Basic
    @Column(name = "updatedate")
    public LocalDate getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(LocalDate updatedate) {
        this.updatedate = updatedate;
    }

    @Basic
    @Column(name = "duedate")
    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    @Basic
    @Column(name = "resolvedate")
    public LocalDate getResolvedate() {
        return resolvedate;
    }

    public void setResolvedate(LocalDate resolvedate) {
        this.resolvedate = resolvedate;
    }

    @Basic
    @Column(name = "closeddate")
    public LocalDate getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(LocalDate closeddate) {
        this.closeddate = closeddate;}

    @Basic
    @Column(name = "estimation")
    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

//    @Basic
//    @Column(name = "shortdescription")
//    public String getShortdescription() {
//        return shortdescription;
//    }
//
//    public void setShortdescription(String shortdescription) {
//        this.shortdescription = shortdescription;
//    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Basic
//    @Column(name = "timeused")
//    public int getTimeused() {
//        return timeused;
//    }
//
//    public void setTimeused(int timeused) {
//        this.timeused = timeused;
//    }

//    @Basic
//    @Column(name = "attachments")
//    public byte[] getAttachments() {
//        return attachments;
//    }
//
//    public void setAttachments(byte[] attachments) {
//        this.attachments = attachments;
//    }

//    @Basic
//    @Column(name = "timeleft")
//    public int getTimeleft() {
//        return timeleft;
//    }
//
//    public void setTimeleft(int timeleft) {
//        this.timeleft = timeleft;
//    }

//    @Basic
//    @Column(name = "Projects_id")
//    public int getProjectsId() {
//        return projectsId;
//    }
//
//    public void setProjectsId(int projectsId) {
//        this.projectsId = projectsId;
//    }
//
//    @Basic
//    @Column(name = "Priorities_id")
//    public int getPrioritiesId() {
//        return prioritiesId;
//    }
//
//    public void setPrioritiesId(int prioritiesId) {
//        this.prioritiesId = prioritiesId;
//    }

//    @Basic
//    @Column(name = "Reporter_id")
//    public int getReporterId() {
//        return reporterId;
//    }
//
//    public void setReporterId(int reporterId) {
//        this.reporterId = reporterId;
//    }
//
//    @Basic
//    @Column(name = "Assignee_id1")
//    public int getAssigneeId1() {
//        return assigneeId1;
//    }
//
//    public void setAssigneeId1(int assigneeId1) {
//        this.assigneeId1 = assigneeId1;
//    }
//
//    @Basic
//    @Column(name = "Status_id")
//    public int getStatusId() {
//        return statusId;
//    }
//
//    public void setStatusId(int statusId) {
//        this.statusId = statusId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return id == that.id &&
                //name == that.name &&
                code == that.code &&
                estimation == that.estimation &&
                //timeused == that.timeused &&
                //timeleft == that.timeleft &&
//                projectsId == that.projectsId &&
//                prioritiesId == that.prioritiesId &&
//                reporterId == that.reporterId &&
//                assigneeId1 == that.assigneeId1 &&
//                statusId == that.statusId &&
                Objects.equals(creationdate, that.creationdate) &&
                Objects.equals(updatedate, that.updatedate) &&
                Objects.equals(duedate, that.duedate) &&
                Objects.equals(resolvedate, that.resolvedate) &&
                Objects.equals(closeddate, that.closeddate) &&
                //Objects.equals(shortdescription, that.shortdescription) &&
                Objects.equals(description, that.description);
                //Arrays.equals(attachments, that.attachments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, code, creationdate, updatedate, duedate, resolvedate, closeddate, estimation, /*shortdescription,*/ description /*timeused, timeleft*//*,projectsId,prioritiesId, reporterId, assigneeId1, statusId*/);
        //result = 31 * result + Arrays.hashCode(attachments);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Projects_id", referencedColumnName = "id", nullable = false)
    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "Priorities_id", referencedColumnName = "id", nullable = false)
    public PriorityEntity getPriority() {
        return priority;
    }

    public void setPriority(PriorityEntity priority) {
        this.priority = priority;
    }

    @ManyToOne
    @JoinColumn(name = "Reporter_id", referencedColumnName = "id")
    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    @ManyToOne
    @JoinColumn(name = "Assignee_id1", referencedColumnName = "id", nullable = false)
    public UserEntity getAssignee() {
        return assignee;
    }

    public void setAssignee(UserEntity assignee) {
        this.assignee = assignee;
    }

    @ManyToOne
    @JoinColumn(name = "Status_id", referencedColumnName = "id", nullable = false)
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}
