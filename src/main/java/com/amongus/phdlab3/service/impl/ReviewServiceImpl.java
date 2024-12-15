package com.amongus.phdlab3.service.impl;

import com.amongus.phdlab3.dto.ReviewEntityDto;
import com.amongus.phdlab3.dto.ReviewPage;
import com.amongus.phdlab3.entity.ReviewEntity;
import com.amongus.phdlab3.repository.ReviewRepository;
import com.amongus.phdlab3.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        ReviewEntityDto reviewDTO = modelMapper.map(reviewEntity, ReviewEntityDto.class);
        return new ResponseEntity(reviewDTO, HttpStatus.OK);
    }

    @Override
    @Cacheable("page")
    public ReviewPage getAll(Pageable pageable) {
        Page<ReviewEntity> reviewEntities = reviewRepository.findAll(pageable);
        return new ReviewPage(
                reviewEntities.getContent(),
                reviewEntities.getNumber(),
                reviewEntities.getSize(),
                reviewEntities.getTotalElements(),
                reviewEntities.getTotalPages()
        );
    }

    @Override
    @CacheEvict(value = "page")
    public ResponseEntity<?> edit(ReviewEntityDto reviewEntityDto) {
        ReviewEntity review = reviewRepository.findById(reviewEntityDto.getId()).orElseThrow();
        ReviewEntity review1 = modelMapper.map(reviewEntityDto, ReviewEntity.class);
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
    @CacheEvict(value = "page")
    public ResponseEntity<?> deleteById(String id) {
        reviewRepository.deleteById(id);
        return new ResponseEntity("placeholder", HttpStatus.OK);
    }

    @Override
    @CacheEvict(value = "page")
    public ResponseEntity<?> create(ReviewEntityDto reviewDTO) {
        System.out.println(reviewDTO);
        ReviewEntity reviewEntity = modelMapper.map(reviewDTO, ReviewEntity.class);
        System.out.println(reviewEntity);
        reviewRepository.save(reviewEntity);
        return new ResponseEntity(reviewEntity, HttpStatus.CREATED);
    }

    @Override
    @Cacheable("page")
    public ResponseEntity<?> find(String name, Pageable pageable) {
        Page<ReviewEntity> reviewEntities = reviewRepository.findAllByProductContainingIgnoreCase(name,pageable);
        System.out.println(reviewEntities);
        List<ReviewEntityDto> reviewDTOS = reviewEntities.getContent().stream()
                .map(reviewEntity -> modelMapper.map(reviewEntity, ReviewEntityDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(reviewDTOS, HttpStatus.OK);
    }
}
