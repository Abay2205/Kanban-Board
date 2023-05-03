package com.example.kanban.service.impl;

import com.example.kanban.entity.Subtasks;
import com.example.kanban.entity.Tasks;
import com.example.kanban.repository.SubtasksRepository;
import com.example.kanban.service.SubtasksService;
import com.example.kanban.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtasksServiceImpl implements SubtasksService {

    @Autowired
    private SubtasksRepository subtasksRepository;

    @Override
    public Subtasks getSubtaskById(Long subtaskId) {
        return subtasksRepository.findById(subtaskId).orElse(null);
    }



    @Override
    public Subtasks updateSubtask(Long subtaskId, Subtasks subtask) {
        Subtasks existingSubtask = subtasksRepository.findById(subtaskId).orElse(null);
        if (existingSubtask == null) {
            return null;
        } else {
            existingSubtask.setSubtaskName(subtask.getSubtaskName());
            existingSubtask.setDescription(subtask.getDescription());
            existingSubtask.setCompleted(subtask.isCompleted());
            return subtasksRepository.save(existingSubtask);
        }
    }

    @Override
    public void deleteSubtask(Long subtaskId) {
        subtasksRepository.deleteById(subtaskId);
    }

    @Override
    public Subtasks saveSubtask(Subtasks subtasks) {
        return subtasksRepository.save(subtasks);
    }

    @Override
    public Page<Subtasks> findAllSubtasks(String keyword, int pageNumber, int pageSize, String sortDirection, String sortBy, int priceFilter) {
        Pageable pageable = PaginationUtils.pageable(pageNumber, pageSize, sortDirection, sortBy);
        return subtasksRepository.findAll(keyword, pageable, priceFilter);
    }
}
