package com.example.kanban.controller;

import com.example.kanban.dto.PhotosUploadResponse;
import com.example.kanban.entity.Photos;
import com.example.kanban.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


//@CrossOrigin(origins = "http://localhost:4203")
@RestController
@RequestMapping("/back10/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<PhotosUploadResponse> upload(@RequestParam("files") MultipartFile file) throws IOException {
        return ResponseEntity.ok(PhotosUploadResponse.builder()
                .id(photoService.addFile(file)).build()
        );


    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        Photos photos = photoService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photos.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photos.getFileName() + "\"")
                .body(new ByteArrayResource(photos.getFile()));
    }

}

