package com.amongus.phdlab3.dto;

import com.amongus.phdlab3.entity.ReviewEntity;

import java.io.Serializable;
import java.util.List;

public class ReviewPage implements Serializable {
    private List<ReviewEntity> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    // Default constructor (required for deserialization)
    public ReviewPage() {}

    // Parameterized constructor
    public ReviewPage(List<ReviewEntity> content, int pageNumber, int pageSize, long totalElements, int totalPages) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    // Getters and Setters
    public List<ReviewEntity> getContent() {
        return content;
    }

    public void setContent(List<ReviewEntity> content) {
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}