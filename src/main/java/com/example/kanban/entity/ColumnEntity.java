package com.example.kanban.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "columnEntity")
public class ColumnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long columnId;
    @Column
    private String title;
    @Column
    private String color;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_columnId", referencedColumnName = "columnId")
    private List<Tasks> tasks;

    public ColumnEntity() {
    }

    public ColumnEntity(Long columnId, String title, String color, List<Tasks> tasks) {
        this.columnId = columnId;
        this.title = title;
        this.color = color;
        this.tasks = tasks;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}

