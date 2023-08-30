package com.losdinolol.spring6webapp.repositories;

import com.losdinolol.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespository extends CrudRepository<Publisher, Long> {
}
