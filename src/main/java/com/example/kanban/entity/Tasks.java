package com.example.kanban.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column
    private String taskName;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private Integer priority;

    @Column
    private String taskImageId;

    @Column
    private String developer;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deadline_hours")
    private Integer deadlineHours;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_taskId", referencedColumnName = "taskId")
    private List<Subtasks> subtasks;

    public Tasks() {
        this.subtasks = new ArrayList<>();
    }

    public Tasks(Long taskId, String taskName, String description, String status, Integer priority, String taskImageId, String developer, LocalDateTime createdAt, Integer deadlineHours, List<Subtasks> subtasks) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.taskImageId = taskImageId;
        this.developer = developer;
        this.createdAt = createdAt;
        this.deadlineHours = deadlineHours;
        this.subtasks = subtasks;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTaskImageId() {
        return taskImageId;
    }

    public void setTaskImageId(String taskImageId) {
        this.taskImageId = taskImageId;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Subtasks> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtasks> subtasks) {
        this.subtasks = subtasks;
    }

    public Integer getDeadlineHours() {
        return deadlineHours;
    }

    public void setDeadlineHours(Integer deadlineHours) {
        this.deadlineHours = deadlineHours;
    }
}
