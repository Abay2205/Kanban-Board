package com.example.kanban.service;

import com.example.kanban.entity.Subtasks;
import com.example.kanban.entity.Tasks;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubtasksService {


    Subtasks getSubtaskById(Long subtaskId);

    Subtasks updateSubtask(Long subtaskId, Subtasks subtask);
    void deleteSubtask(Long subtaskId);

    Subtasks saveSubtask(Subtasks subtasks);

    Page<Subtasks> findAllSubtasks(String keyword, int pageNumber, int pageSize, String sortDirection, String sortBy, int priceFilter);
}
