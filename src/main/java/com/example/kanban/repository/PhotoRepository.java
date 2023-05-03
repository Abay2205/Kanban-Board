package com.example.kanban.repository;

import com.example.kanban.entity.Photos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photos, String> {
}
