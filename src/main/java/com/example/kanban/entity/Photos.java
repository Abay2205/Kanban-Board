package com.example.kanban.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task_photos")
public class Photos {

    private String fileName;
    private String fileType;
    private String fileSize;
    private byte[] file;

    public Photos() {
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
