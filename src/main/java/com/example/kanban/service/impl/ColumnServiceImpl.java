package com.example.kanban.service.impl;

import com.example.kanban.entity.ColumnEntity;
import com.example.kanban.exception.ResourceNotFoundException;
import com.example.kanban.repository.ColumnRepository;
import com.example.kanban.repository.TaskRepository;
import com.example.kanban.service.ColumnService;
import com.example.kanban.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColumnServiceImpl implements ColumnService {

    private final ColumnRepository columnRepository;

    private final TaskRepository taskRepository;

    public ColumnServiceImpl(ColumnRepository columnRepository, TaskRepository taskRepository) {
        this.columnRepository = columnRepository;
        this.taskRepository = taskRepository;
    }

//    @Override
//    public List<ColumnEntity> findAllColumns() {
//        return columnRepository.findAll();
//    }

    @Override
    public Object findColumnById(Long id) {
        Optional<ColumnEntity> columnEntity = columnRepository.findById(id);
        if(columnEntity.isPresent()){
            return columnEntity.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public ColumnEntity saveColumn(ColumnEntity columnEntity) {
         return columnRepository.save(columnEntity);
//         return ResponseEntity.ok("Data saved");
    }

    @Override
    public void deleteColumn(Long id) {
        columnRepository.deleteById(id);
    }

    @Override
    public ColumnEntity updateColumn(ColumnEntity columnEntity, Long id) {
        ColumnEntity existingCol = columnRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "Id", id));
        existingCol.setTitle(columnEntity.getTitle());
        existingCol.setColor(columnEntity.getColor());
        existingCol.setTasks(columnEntity.getTasks());
        columnRepository.save(existingCol);
        return existingCol;
    }

    @Override
    public Page<ColumnEntity> findAllColumns(String keyword, int pageNumber, int pageSize, String sortDirection, String sortBy, int priceFilter) {
        Pageable pageable = PaginationUtils.pageable(pageNumber, pageSize, sortDirection, sortBy);
        return columnRepository.findAll(keyword, pageable, priceFilter);
    }

//    @Override
//    public ColumnEntity assignTaskToColumn(Long columnId, Long taskId) {
//        Set<Tasks> tasksList = null;
//        ColumnEntity columnEntity = columnRepository.findById(columnId).get();
//        Tasks tasks = taskRepository.findById(taskId).get();
//        tasksList = columnEntity.getAssignedTasks();
//        tasksList.add(tasks);
//        columnEntity.setAssignedTasks(tasksList);
//        return columnRepository.save(columnEntity);
//    }
}
