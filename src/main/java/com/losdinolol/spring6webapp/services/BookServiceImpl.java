package com.losdinolol.spring6webapp.services;

import com.losdinolol.spring6webapp.domain.Book;
import com.losdinolol.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
