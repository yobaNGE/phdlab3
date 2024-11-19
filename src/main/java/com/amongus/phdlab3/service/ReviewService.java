package com.amongus.phdlab3.service;

import com.amongus.phdlab3.entity.ReviewEntity;
import org.springframework.http.ResponseEntity;

public interface ReviewService {
    public ResponseEntity<?> getById(String id);
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> edit(ReviewEntity reviewEntity);
    public ResponseEntity<?> deleteById(String id);
    public ResponseEntity<?> create(ReviewEntity reviewEntity);
}
