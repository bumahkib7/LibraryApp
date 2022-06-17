package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service("bookService")
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public void deleteBook(Book book) {
        bookRepo.delete(book);
    }

    public void updateBook(Book book) {
        if (!bookRepo.existsById(book.getId())) {
            bookRepo.save(book);
        }
    }


    public void findBookById(Long id) {
        if (bookRepo.findById(id).isPresent()) {
            System.out.println(bookRepo.findById(id).get());
            bookRepo.findById(id);
        }
    }


    public void getAllBooks( ) {
        HashMap<Long, Book> books = new HashMap<>();
        bookRepo.findAll().forEach(book -> books.put(book.getId(), book));
    }
}
