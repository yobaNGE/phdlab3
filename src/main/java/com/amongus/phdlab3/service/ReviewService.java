package com.amongus.phdlab3.service;

import com.amongus.phdlab3.dto.ReviewEntityDto;
import com.amongus.phdlab3.dto.ReviewPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReviewService {
    public ResponseEntity<?> getById(String id);
    public ReviewPage getAll(Pageable pageable);
    public ResponseEntity<?> edit(ReviewEntityDto reviewEntityDto);
    public ResponseEntity<?> deleteById(String id);
    public ResponseEntity<?> create(ReviewEntityDto reviewEntityDto);
    public ResponseEntity<?> find(String name, Pageable pageable);
}
