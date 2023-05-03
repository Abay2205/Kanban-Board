package com.example.kanban.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils {

    public static Pageable pageable(int pageNumber, int pageSize, String sortDirection, String sortBy) {
        return PageRequest.of(pageNumber, pageSize, sortDirection.equals("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
    }

}
