package com.bookwishlist;

public class Book {
    private String addTitle;
    private String addAuthor;

    public Book(String title, String author) {
        this.addTitle = title;
        this.addAuthor = author;
    }

    public String getTitle(){
        return addTitle;
    }

    public String getAuthor(){
        return addAuthor;
    }
    
}
