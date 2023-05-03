package com.example.kanban.repository;

import com.example.kanban.entity.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Tasks, Long> {

    @Query("SELECT p FROM Tasks p WHERE " +
            "(CONCAT(p.taskName, ' ', p.description, ' ', p.status, ' ', p.priority, ' ', p.developer, ' ') LIKE concat('%', ?1,'%'))" +
            " or ?1 = ''")
    Page<Tasks> findAll(String keyword, Pageable pageable, int priceFilter);
}
