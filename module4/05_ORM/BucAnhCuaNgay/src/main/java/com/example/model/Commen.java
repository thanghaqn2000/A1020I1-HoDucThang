package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long rating;
    private String author;
    private String feedback;
    private int countLike;

    public Commen() {
    }

    public Commen(long id, long rating, String author, String feedback, int countLike) {
        this.id = id;
        this.rating = rating;
        this.author = author;
        this.feedback = feedback;
        this.countLike = countLike;
    }

    public Commen(long rating, String author, String feedback, int countLike) {
        this.rating = rating;
        this.author = author;
        this.feedback = feedback;
        this.countLike = countLike;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int like) {
        this.countLike = like;
    }
}
