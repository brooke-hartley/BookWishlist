package com.bookwishlist;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> library;

    // Method to initialize new library
    public Library() {
        this.library = new ArrayList<>();
    }

    // Method to add a new book to library
    public void addBook(Book book){
        library.add(book);
    }

    // Method to retrieve the list of books
    public ArrayList<Book> getBooks() {
        return library;
    }

}
