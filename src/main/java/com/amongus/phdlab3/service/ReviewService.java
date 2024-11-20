package com.amongus.phdlab3.service;

import com.amongus.phdlab3.dto.ReviewDTO;
import com.amongus.phdlab3.entity.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReviewService {
    public ResponseEntity<?> getById(String id);
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> edit(ReviewDTO reviewEntity);
    public ResponseEntity<?> deleteById(String id);
    public ResponseEntity<?> create(ReviewDTO reviewEntity);
}
