package com.example.kanban.service.impl;

import com.example.kanban.entity.Tasks;
import com.example.kanban.exception.ResourceNotFoundException;
import com.example.kanban.repository.TaskRepository;
import com.example.kanban.service.TaskService;
import com.example.kanban.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Page<Tasks> findAllTasks(String keyword, int pageNumber, int pageSize, String sortDirection, String sortBy, int priceFilter) {
        Pageable pageable = PaginationUtils.pageable(pageNumber, pageSize, sortDirection, sortBy);
        return taskRepository.findAll(keyword, pageable, priceFilter);
    }

    @Override
    public Tasks findTaskById(Long id) {
        Optional<Tasks> tasks = taskRepository.findById(id);
        if(tasks.isPresent()){
            return tasks.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Tasks saveTask(Tasks tasks) {
        return taskRepository.save(tasks);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Tasks updateTask(Tasks tasks, Long id) {
        Tasks existingTask = taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "Id", id));
        existingTask.setTaskName(tasks.getTaskName());
        existingTask.setDescription(tasks.getDescription());
        existingTask.setStatus(tasks.getStatus());
        existingTask.setPriority(tasks.getPriority());
        existingTask.setTaskImageId(tasks.getTaskImageId());
        existingTask.setDeveloper(tasks.getDeveloper());
        existingTask.setDeadlineHours(tasks.getDeadlineHours());
        existingTask.setSubtasks(tasks.getSubtasks());
        taskRepository.save(existingTask);
        return existingTask;
    }
}
