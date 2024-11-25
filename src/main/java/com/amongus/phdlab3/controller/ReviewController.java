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
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getReview(@PathVariable("id") String id){
        return reviewService.getById(id);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllReviews(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit){

        return reviewService.getAll(PageRequest.of(offset,limit));
    }
    @PostMapping("/get")
    public ResponseEntity<?> addReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.create(reviewDTO);
    }
    @PutMapping("/get/{id}")
    public ResponseEntity<?> editReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.edit(reviewDTO);
    }
    @DeleteMapping("/get/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") String id){
        return reviewService.deleteById(id);
    }
    @GetMapping("/find")
    public ResponseEntity<?> find(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                  @RequestParam(value = "name", defaultValue = "nuuuf") String name){
        return reviewService.find(name, PageRequest.of(offset,limit));
    }
}
