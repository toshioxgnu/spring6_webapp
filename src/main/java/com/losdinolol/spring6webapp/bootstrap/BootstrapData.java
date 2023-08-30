package com.losdinolol.spring6webapp.bootstrap;

import com.losdinolol.spring6webapp.domain.Author;
import com.losdinolol.spring6webapp.domain.Book;
import com.losdinolol.spring6webapp.domain.Publisher;
import com.losdinolol.spring6webapp.repositories.AuthorRepository;
import com.losdinolol.spring6webapp.repositories.BookRepository;
import com.losdinolol.spring6webapp.repositories.PublisherRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRespository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRespository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Author rodSaved = authorRepository.save(rod);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("987654321");

        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("SFG Publishing");
        publisher.setAddres("1234 Main St");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setZip("12345");

        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());

    }
}
