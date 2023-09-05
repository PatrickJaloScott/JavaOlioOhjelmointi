package com.metropolia.library;

public class LibraryProgram {
    public static void main(String[] args) {
        Book introToJava = new Book("Introduction to Java Programming", "John Smith",2020),
                dataStructure = new Book("Data Structures and Algorithms", "Jane Doe",2018),
                artOfFiction = new Book("The Art of Fiction","Alice Johnson",2019);
        User john = new User("John", 25),
                james = new User("James", 21),
                jack = new User("Jack", 15),
                jill = new User("Jill", 27);
        Library oodi = new Library();

        introToJava.setRating(4);
        dataStructure.setRating(3);
        artOfFiction.setRating(2);

        oodi.addBook(introToJava);
        oodi.addBook(dataStructure);
        oodi.addBook(artOfFiction);

        oodi.addUser(john);
        oodi.addUser(james);
        oodi.addUser(jack);
        oodi.addUser(jill);

        oodi.displayBooks();
        oodi.findBooksByAuthor("Jane Doe");

        john.borrowBook(oodi, "Introduction to Java Programming");
        james.borrowBook(oodi,"Introduction to Java Programming");
        john.returnBook(oodi, "Introduction to Java Programming");
        james.borrowBook(oodi, "Introduction to Java Programming");

        String bookName = "How to write a book";
        if (oodi.isBookAvailable(bookName)) {
            System.out.println("\nBook: " + bookName + " found");
        }
        else {
            System.out.println("\nBook: \"" + bookName + "\" not found");
        }
        jack.borrowBook(oodi, bookName);

        Book amazingBook = new Book("The BEST book ever", "Amazing Author", 2013);
        amazingBook.setRating(5);
        amazingBook.addReview("Awesome!");
        amazingBook.addReview("The best!!");
        amazingBook.addReview("Can't wait for the sequel!");
        oodi.addBook(amazingBook);

        System.out.printf("\nThe average book rating is %.2f\n", oodi.getAverageBookRating());
        System.out.println("The most reviewed book is: " + oodi.getMostReviewedBook().getTitle());
    }
}
