package com.example.kanban.controller;

import com.example.kanban.entity.Tasks;
import com.example.kanban.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4203")
@RestController
@RequestMapping("/back10/Task")
public class TaskController {
    private final TaskService taskService;

public TaskController(TaskService taskService){this.taskService = taskService;}

    @GetMapping
    public Page<Tasks> findAllProducts(@RequestParam(required = false , name = "keywords", defaultValue = "") String keyword,
                                                @RequestParam(required = false, name = "pageNumber", defaultValue = "0") int pageNumber,
                                                @RequestParam(required = false, name ="pageSize", defaultValue = "15") int pageSize,
                                                @RequestParam(required = false, name ="sortDirection", defaultValue = "asc") String sortDirection,
                                                @RequestParam(required = false, name ="sortBy", defaultValue = "id") String sortBy,
                                                @RequestParam(required = false, name = "priceFilter", defaultValue = "0") int priceFilter) {
        return taskService.findAllTasks(keyword, pageNumber, pageSize, sortDirection, sortBy, priceFilter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> findTaskById(@PathVariable("id") Long id){
    return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @PostMapping
    public Tasks saveTask(@RequestBody Tasks tasks){
    return taskService.saveTask(tasks);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id){taskService.deleteTask(id);}

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable("id") Long id,
                                            @RequestBody Tasks tasks){
    return new ResponseEntity<>(taskService.updateTask(tasks, id), HttpStatus.OK);
    }
}
