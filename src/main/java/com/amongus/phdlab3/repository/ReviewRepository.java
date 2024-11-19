package com.amongus.phdlab3.repository;

import com.amongus.phdlab3.entity.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<ReviewEntity, String> {
    Optional<ReviewEntity> findById(String id);
    List<ReviewEntity> findAll();
}
