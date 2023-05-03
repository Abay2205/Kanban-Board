package com.example.kanban.repository;

import com.example.kanban.entity.ColumnEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColumnRepository extends JpaRepository<ColumnEntity, Long> {

    @Query("SELECT p FROM ColumnEntity p WHERE " +
            "(CONCAT(p.title, ' ', p.color, ' ') LIKE concat('%', ?1,'%'))" +
            " or ?1 = ''")
    Page<ColumnEntity> findAll(String keyword, Pageable pageable, int priceFilter);
}
