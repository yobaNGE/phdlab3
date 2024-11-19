package com.amongus.phdlab3.controller;

import com.amongus.phdlab3.entity.ReviewEntity;
import com.amongus.phdlab3.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getReview(@RequestParam("id") String id){
        return reviewService.getById(id);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllReviews(){
        return reviewService.getAll();
    }
    @PostMapping("/create")
    public ResponseEntity<?> addReview(ReviewEntity reviewEntity){
        return reviewService.create(reviewEntity);
    }
    @PutMapping("/update")
    public ResponseEntity<?> editReview(ReviewEntity reviewEntity){
        return reviewService.edit(reviewEntity);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteReview(@RequestParam("id") String id){
        return reviewService.deleteById(id);
    }
}
