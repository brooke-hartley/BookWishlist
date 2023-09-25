package com.bookwishlist;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> library;
    int index = 0;

    public void initLibrary() {
        this.library = new ArrayList<>();
    }

    public void addBook(Book book){
        library.add(index, book);
        index++;
    }

}
