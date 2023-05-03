package com.example.kanban.repository;

import com.example.kanban.entity.Subtasks;
import com.example.kanban.entity.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubtasksRepository extends JpaRepository<Subtasks, Long> {
    @Query("SELECT p FROM Tasks p WHERE " +
            "(CONCAT(p.taskName, ' ', p.description, ' ', p.status, ' ', p.priority, ' ', p.developer, ' ') LIKE concat('%', ?1,'%'))" +
            " or ?1 = ''")
    Page<Subtasks> findAll(String keyword, Pageable pageable, int priceFilter);
}