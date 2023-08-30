package com.losdinolol.spring6webapp.services;

import com.losdinolol.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
