package model.library;

import java.util.ArrayList;

public class Book {
    private String title, author, isbn;
    private int publicationYear;
    private int reservedMemberID = 0;
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
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

    public String getISBN() {
        return isbn;
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

    public boolean setReservation(int memberID) {
        boolean canReserve = true;
        if(reservedMemberID == 0) {
            reservedMemberID = memberID;
        }
        else {
            canReserve = false;
        }
        return canReserve;
    }

    public boolean canBorrow(User member) {
        return (reservedMemberID == 0 || reservedMemberID == member.getMemberID());
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }
}
