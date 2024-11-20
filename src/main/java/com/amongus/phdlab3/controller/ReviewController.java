package com.amongus.phdlab3.controller;

import com.amongus.phdlab3.dto.ReviewDTO;
import com.amongus.phdlab3.entity.ReviewEntity;
import com.amongus.phdlab3.service.ReviewService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getReview(@RequestParam("id") String id){
        return reviewService.getById(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllReviews(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit){

        return reviewService.getAll(PageRequest.of(offset,limit));
    }
    @PostMapping("/create")
    public ResponseEntity<?> addReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.create(reviewDTO);
    }
    @PutMapping("/update")
    public ResponseEntity<?> editReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.edit(reviewDTO);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteReview(@RequestParam("id") String id){
        return reviewService.deleteById(id);
    }
}
