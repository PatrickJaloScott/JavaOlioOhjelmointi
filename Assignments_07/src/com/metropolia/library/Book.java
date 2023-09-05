package com.metropolia.library;

import java.util.ArrayList;

public class Book {
    private String title, author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void setRating(double rating) {
        if(rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
        else {
            System.out.println("Invalid rating value!");
        }
    }

    public void addReview(String review) {
        if (!review.isBlank()) {
            reviews.add(review);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public int getReviewAmount() {
        return reviews.size();
    }
}
