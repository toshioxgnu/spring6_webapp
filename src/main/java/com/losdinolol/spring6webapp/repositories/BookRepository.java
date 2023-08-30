package com.losdinolol.spring6webapp.repositories;

import com.losdinolol.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
