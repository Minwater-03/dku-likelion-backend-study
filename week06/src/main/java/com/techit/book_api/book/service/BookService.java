package com.techit.book_api.book.service;

import com.techit.book_api.book.dto.BookRequest;
import com.techit.book_api.book.dto.BookResponse;
import com.techit.book_api.book.entity.Book;
import com.techit.book_api.book.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 책 등록
    public BookResponse createBook(BookRequest request) {
        Book book = new Book(
                request.getTitle(),
                request.getPrice(),
                request.getAuthor()
        );

        Book savedBook = bookRepository.save(book);

        return new BookResponse(savedBook);
    }

    // 책 전체 조회
    public List<BookResponse> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::new)
                .toList();
    }

    // 책 단건 조회
    public BookResponse getBook(Long id) {
        Book book = findBookById(id);

        return new BookResponse(book);
    }

    // 책 수정
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = findBookById(id);

        book.update(
                request.getTitle(),
                request.getPrice(),
                request.getAuthor()
        );

        return new BookResponse(book);
    }

    // 책 삭제
    public void deleteBook(Long id) {
        Book book = findBookById(id);

        bookRepository.delete(book);
    }

    // 공통 조회 메서드
    private Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "해당 책을 찾을 수 없습니다."
                ));
    }
}