package com.techit.book_api.book.controller;

import com.techit.book_api.book.dto.BookRequest;
import com.techit.book_api.book.dto.BookResponse;
import com.techit.book_api.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 책 등록
    @PostMapping
    public ResponseEntity<BookResponse> createBook(
            @RequestBody BookRequest request
    ) {
        BookResponse response = bookService.createBook(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // 책 전체 조회
    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        List<BookResponse> response = bookService.getBooks();

        return ResponseEntity.ok(response);
    }

    // 책 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(
            @PathVariable Long id
    ) {
        BookResponse response = bookService.getBook(id);

        return ResponseEntity.ok(response);
    }

    // 책 수정
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequest request
    ) {
        BookResponse response = bookService.updateBook(id, request);

        return ResponseEntity.ok(response);
    }

    // 책 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id
    ) {
        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}