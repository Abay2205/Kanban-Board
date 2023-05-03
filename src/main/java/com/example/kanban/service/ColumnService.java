package com.example.kanban.service;

import com.example.kanban.entity.ColumnEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ColumnService {

//    List<ColumnEntity> findAllColumns();

    Object findColumnById(Long id);


    ColumnEntity saveColumn(ColumnEntity columnEntity);

    void deleteColumn(Long id);

    Object updateColumn(ColumnEntity columnEntity, Long id);

    Page<ColumnEntity> findAllColumns(String keyword, int pageNumber, int pageSize, String sortDirection, String sortBy, int priceFilter);

//    ColumnEntity assignTaskToColumn(Long columnId, Long taskId);
}
