package com.losdinolol.spring6webapp.services;

import com.losdinolol.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
