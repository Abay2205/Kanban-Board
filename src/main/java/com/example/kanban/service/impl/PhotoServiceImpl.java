package com.example.kanban.service.impl;

import com.example.kanban.entity.Photos;
import com.example.kanban.service.PhotoService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private GridFsTemplate template;
    @Autowired
    private GridFsOperations operations;
    public String addFile(MultipartFile upload) throws IOException {
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());

        Object fileId = template.store(upload.getInputStream(),
                upload.getOriginalFilename(), upload.getContentType(), metadata);

        return fileId.toString();
    }
    public Photos downloadFile(String id) throws IOException{
        GridFSFile gridFSFile = template.findOne(new Query(Criteria.where("_id").is(id)));

        Photos photos = new Photos();

        if(gridFSFile != null && gridFSFile.getMetadata() != null){

            photos.setFileName( gridFSFile.getFilename());

            photos.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

            photos.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            photos.setFile(IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()));

        }
        return photos;
    }

}
