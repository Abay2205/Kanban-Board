package com.example.kanban.service;

import com.example.kanban.entity.Tasks;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {
    Page<Tasks> findAllTasks(String keyword, int pageNumber, int pageSize, String sortDirection, String sortBy, int priceFilter);

    Tasks findTaskById(Long id);

    Tasks saveTask(Tasks tasks);

    void deleteTask(Long id);

    Tasks updateTask(Tasks tasks, Long id);
}
