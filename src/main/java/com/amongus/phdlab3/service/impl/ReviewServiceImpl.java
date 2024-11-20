package com.amongus.phdlab3.service.impl;

import com.amongus.phdlab3.dto.ReviewDTO;
import com.amongus.phdlab3.entity.ReviewEntity;
import com.amongus.phdlab3.repository.ReviewRepository;
import com.amongus.phdlab3.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> getById(String id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).orElseThrow();
        ReviewDTO reviewDTO = modelMapper.map(reviewEntity, ReviewDTO.class);
        return new ResponseEntity(reviewDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<ReviewEntity> reviewEntities = reviewRepository.findAll(pageable);
        return new ResponseEntity(reviewEntities, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> edit(ReviewDTO reviewDTO) {
        ReviewEntity review = reviewRepository.findById(reviewDTO.getId()).orElseThrow();
        ReviewEntity review1 = modelMapper.map(reviewDTO, ReviewEntity.class);
        review.setUsername(review1.getUsername());
        review.setProduct(review1.getProduct());
        review.setRating(review1.getRating());
        review.setComment(review1.getComment());
        review.setDate(review1.getDate());
        review.setTags(review1.getTags());
        reviewRepository.save(review);
        return new ResponseEntity(review, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        reviewRepository.deleteById(id);
        return new ResponseEntity("placeholder", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(ReviewDTO reviewDTO) {
        System.out.println(reviewDTO);
        ReviewEntity reviewEntity = modelMapper.map(reviewDTO, ReviewEntity.class);
        System.out.println(reviewEntity);
        reviewRepository.save(reviewEntity);
        return new ResponseEntity(reviewEntity, HttpStatus.CREATED);
    }

}
