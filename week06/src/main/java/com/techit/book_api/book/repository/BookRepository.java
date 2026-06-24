package com.techit.book_api.book.repository;

import com.techit.book_api.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}