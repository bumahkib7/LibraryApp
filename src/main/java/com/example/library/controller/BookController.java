package com.example.library.controller;

import com.example.library.models.Book;
import com.example.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public void showAllBooks() {
        bookService.getAllBooks();
    }

    @PostMapping("/add")
    public void addBookToLibrary(Book book) {
        bookService.addBook(book);
    }
}
