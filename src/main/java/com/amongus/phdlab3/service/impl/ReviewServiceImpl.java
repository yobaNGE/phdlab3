package com.amongus.phdlab3.service.impl;

import com.amongus.phdlab3.entity.ReviewEntity;
import com.amongus.phdlab3.repository.ReviewRepository;
import com.amongus.phdlab3.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ResponseEntity<?> getById(String id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).orElseThrow();
        return new ResponseEntity(reviewEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        return new ResponseEntity(reviewEntities, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> edit(ReviewEntity reviewEntity) {
        ReviewEntity review = reviewRepository.findById(reviewEntity.getId()).orElseThrow();
        review.setUsername(reviewEntity.getUsername());
        review.setProduct(reviewEntity.getProduct());
        review.setRating(reviewEntity.getRating());
        review.setComment(reviewEntity.getComment());
        review.setDate(reviewEntity.getDate());
        review.setTags(reviewEntity.getTags());
        reviewRepository.save(review);
        return new ResponseEntity(review, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        reviewRepository.deleteById(id);
        return new ResponseEntity("placeholder", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(ReviewEntity reviewEntity) {
        reviewRepository.save(reviewEntity);
        return new ResponseEntity(reviewEntity, HttpStatus.CREATED);
    }

}
