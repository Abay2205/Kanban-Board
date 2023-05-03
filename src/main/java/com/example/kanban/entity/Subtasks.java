package com.example.kanban.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subtasks")
public class Subtasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subtaskId;

    @Column
    private String subtaskName;

    @Column
    private String description;

    @Column
    private boolean isCompleted;

    public Subtasks() {
    }

    public Subtasks(String subtaskName, String description, boolean isCompleted) {
        this.subtaskName = subtaskName;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public Long getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(Long subtaskId) {
        this.subtaskId = subtaskId;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
