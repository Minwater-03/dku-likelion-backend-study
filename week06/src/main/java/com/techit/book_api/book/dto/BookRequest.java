package com.techit.book_api.book.dto;

public class BookRequest {

    private String title;
    private Integer price;
    private String author;

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