package com.example.kanban.service;

import com.example.kanban.entity.Photos;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String addFile(MultipartFile file) throws IOException;

    Photos downloadFile(String id) throws IOException;
}
