package model.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final ArrayList<Book> listedBooks = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();
    private final ArrayList<Book> reservedBooks = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        listedBooks.add(book);
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void displayBooks() {
        System.out.println("\nLibrary Catalog:");
        for(Book b : listedBooks) {
            System.out.println(listedBooks.indexOf(b)+1 + ". Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Year: " + b.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author " + author);
        for (Book b : listedBooks) {
            if (b.getAuthor().equals(author)) {
                System.out.println("Title: " + b.getTitle() + ", Year: " + b.getPublicationYear());
            }
        }
    }

    public void borrowBookByTitle(User user, String title) {
        Book bookToBorrow = null;
        for (Book b : listedBooks) {
            if (!borrowedBooks.contains(b) && b.canBorrow(user)) {
                borrowedBooks.add(b);
                bookToBorrow = b;
                System.out.println("Book \"" + title + "\" was borrowed");
            }
            else {
                System.out.println("Book \"" + title + "\" could not be borrowed");
            }
        }
        if (bookToBorrow != null) {
            borrowedBooks.add(bookToBorrow);
            System.out.println("\nTitle: " + title + " was borrowed");
        }
        else {
            System.out.println("\nCould not find book: " + title);
        }
    }

    public void borrowBookByID(User user, String id) {
        for (Book book : listedBooks) {
            if (book.getISBN().equals(id)) {
                if (isBookAvailable(book.getTitle()) && book.canBorrow(user)) {
                    borrowedBooks.add(book);
                    user.borrowBook(book);
                    System.out.println("Book \"" + id + "\" was borrowed");
                }
                else {
                    System.out.println("Book \"" + id + "\" could not be borrowed");
                }
            }
        }
    }

    /**
     * Reserve a book through this method, using the book's name to find it
     * @param user the user making a reservation
     * @param bookName the name of the book being reserved
     */
    public void reserveBook(User user, String bookName) {
        for (Book book : listedBooks) {
            if (book.getTitle().equals(bookName)) {
                if(book.setReservation(user.getMemberID())) {
                    user.reserveBook(book);
                    reservedBooks.add(book);
                    System.out.println(user.getName() + " made a reservation for \"" + bookName + "\"");
                }
                else {
                    System.out.println("Book \"" + bookName + "\" could not be reserved");
                }
            }
        }
    }

    /**
     cancel a book reservation through the Library Member class
     */
    public void cancelReservation(String bookName) {
        Book bookToCancel = null;
        for (Book book : reservedBooks) {
            if (book.getTitle().equals(bookName)) {
                bookToCancel = book;
            }
        }
        if(bookToCancel != null) {
            bookToCancel.setReservation(0);
            reservedBooks.remove(bookToCancel);
        }
    }

    public void returnBook(Book book) {
        listedBooks.add(book);
        borrowedBooks.remove(book);
        System.out.println("\nReturned \"" + book.getTitle() + "\"");
    }

    public boolean isBookAvailable(String title) {
        boolean isAvailable = false;
        for (Book b : listedBooks) {
            if (b.getTitle().equals(title)) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public double getAverageBookRating() {
        double averageRating = 0;
        for (Book b : listedBooks) {
            averageRating += b.getRating();
        }
        averageRating /= listedBooks.size();
        return averageRating;
    }

    public Book getMostReviewedBook() {
        Book bestBook = listedBooks.get(0);
        for (Book b : listedBooks) {
            if(b.getReviewAmount() > bestBook.getReviewAmount()) {
                bestBook = b;
            }
        }
        return bestBook;
    }

    public List<Book> getListedBooks() {
        return listedBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<User> getUsers() {
        return users;
    }
}
