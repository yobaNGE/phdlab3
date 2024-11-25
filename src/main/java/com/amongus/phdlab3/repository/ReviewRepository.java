package com.amongus.phdlab3.repository;

import com.amongus.phdlab3.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<ReviewEntity, String> {
    Optional<ReviewEntity> findById(String id);
    List<ReviewEntity> findAll();
    Page<ReviewEntity> findAll(Pageable pageable);
    Page<ReviewEntity> findAllByProductContainingIgnoreCase(String product, Pageable pageable);
}
