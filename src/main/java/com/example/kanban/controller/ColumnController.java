package com.example.kanban.controller;

import com.example.kanban.entity.ColumnEntity;

import com.example.kanban.service.ColumnService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/back10/Column")
public class ColumnController {
    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

//    @GetMapping
//    public List<ColumnEntity> findAllColumns() {
//        return columnService.findAllColumns();
//    }
@GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE', 'ROLE_USER')")
public Page<ColumnEntity> findAllColumns(@RequestParam(required = false , name = "keywords", defaultValue = "") String keyword,
                                            @RequestParam(required = false, name = "pageNumber", defaultValue = "0") int pageNumber,
                                            @RequestParam(required = false, name ="pageSize", defaultValue = "15") int pageSize,
                                            @RequestParam(required = false, name ="sortDirection", defaultValue = "asc") String sortDirection,
                                            @RequestParam(required = false, name ="sortBy", defaultValue = "id") String sortBy,
                                            @RequestParam(required = false, name = "priceFilter", defaultValue = "0") int priceFilter) {
    return columnService.findAllColumns(keyword, pageNumber, pageSize, sortDirection, sortBy, priceFilter);
}

    @GetMapping("/{id}")
    public ResponseEntity<ColumnEntity> findColumnById(@PathVariable("id") Long id) {
        return new ResponseEntity<ColumnEntity>((ColumnEntity) columnService.findColumnById(id), HttpStatus.OK);
    }

    @PostMapping
    public ColumnEntity saveColumn(@RequestBody ColumnEntity columnEntity) {
        return columnService.saveColumn(columnEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        columnService.deleteColumn(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColumnEntity> updateColumn(@PathVariable("id") Long id,
                                                     @RequestBody ColumnEntity columnEntity) {
        return new ResponseEntity<ColumnEntity>((ColumnEntity) columnService.updateColumn(columnEntity, id), HttpStatus.OK);
    }

//    @PutMapping("/{columnId}/back10/Task/{taskId}")
//        public ColumnEntity assignTaskToColumn (
//                @PathVariable Long columnId,
//                @PathVariable Long taskId
//    ){
//        return columnService.assignTaskToColumn(columnId, taskId);
//        }

}
