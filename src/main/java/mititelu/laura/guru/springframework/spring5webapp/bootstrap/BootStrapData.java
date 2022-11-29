package mititelu.laura.guru.springframework.spring5webapp.bootstrap;


import mititelu.laura.guru.springframework.spring5webapp.domain.Author;
import mititelu.laura.guru.springframework.spring5webapp.domain.Book;
import mititelu.laura.guru.springframework.spring5webapp.domain.Publisher;
import mititelu.laura.guru.springframework.spring5webapp.repositories.AuthorRepository;
import mititelu.laura.guru.springframework.spring5webapp.repositories.BookRepository;
import mititelu.laura.guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author LMiti3030
 * created on 11/29/2022
 */

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher all = new Publisher("All", "Take Ionescu nr 1", "Bucharest", "Bucharest", "0011357");
        publisherRepository.save(all);
        System.out.println("Number of publishers: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(all);
        all.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(all);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "698462654");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(all);
        all.getBooks().add(noEJB);



        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(all);


        System.out.println("Number of Books: " + bookRepository.count());

        System.out.println("Publisher Number of books " + all.getBooks().size());

    }
}
