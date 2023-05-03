package com.example.kanban.controller;

import com.example.kanban.entity.Subtasks;
import com.example.kanban.entity.Tasks;
import com.example.kanban.service.SubtasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/back10/Subtask")
public class SubtasksController {

    @Autowired
    private SubtasksService subtasksService;


    @GetMapping
    public Page<Subtasks> findAllProducts(@RequestParam(required = false , name = "keywords", defaultValue = "") String keyword,
                                       @RequestParam(required = false, name = "pageNumber", defaultValue = "0") int pageNumber,
                                       @RequestParam(required = false, name ="pageSize", defaultValue = "15") int pageSize,
                                       @RequestParam(required = false, name ="sortDirection", defaultValue = "asc") String sortDirection,
                                       @RequestParam(required = false, name ="sortBy", defaultValue = "id") String sortBy,
                                       @RequestParam(required = false, name = "priceFilter", defaultValue = "0") int priceFilter) {
        return subtasksService.findAllSubtasks(keyword, pageNumber, pageSize, sortDirection, sortBy, priceFilter);
    }
    @GetMapping("/{subtaskId}")
    public ResponseEntity<Subtasks> getSubtaskById(@PathVariable Long subtaskId) {
        Subtasks subtask = subtasksService.getSubtaskById(subtaskId);
        if (subtask == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subtask);
        }
    }

    @PostMapping
    public Subtasks saveSubtask(@RequestBody Subtasks subtasks){
        return subtasksService.saveSubtask(subtasks);
    }

    @PutMapping("/{subtaskId}")
    public ResponseEntity<Subtasks> updateSubtask(@PathVariable Long subtaskId, @RequestBody Subtasks subtask) {
        Subtasks updatedSubtask = subtasksService.updateSubtask(subtaskId, subtask);
        if (updatedSubtask == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedSubtask);
        }
    }

    @DeleteMapping("/{subtaskId}")
    public void deleteSubtask(@PathVariable("subtaskId") Long subtaskId){subtasksService.deleteSubtask(subtaskId);}

}

