package com.techit.book_api.book.dto;

import com.techit.book_api.book.entity.Book;

public class BookResponse {

    private final Long id;
    private final String title;
    private final Integer price;
    private final String author;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.author = book.getAuthor();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}