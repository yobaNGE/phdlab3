package com.amongus.phdlab3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "review")
public class ReviewEntity {
    @Id
    private String id;
    private String username;
    private String product;
    private int rating;
    private String comment;
    private Instant date;
    private List<String> tags;
// поиск по имени продуктам
    protected ReviewEntity() {
    }

    public ReviewEntity(String username, String product, int rating, String comment, Instant date, List<String> tags) {
        this.username = username;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", product='" + product + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", tags=" + tags +
                '}';
    }
}
