package com.example.kanban.dto;



import lombok.Builder;



@Builder
public class PhotosUploadResponse {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
