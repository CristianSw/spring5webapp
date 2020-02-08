package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuhtors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author ron = new Author("Ron","Jonson");
        Book noEJB = new Book("J2EE Development with EJB","123642");

        ron.getBooks().add(noEJB);
        noEJB.getAuhtors().add(ron);

        authorRepository.save(ron);
        bookRepository.save(noEJB);

        Author paulo = new Author("Paulo","Coelho");
        Book alchimist = new Book("The Alchemist", "12321546");

        paulo.getBooks().add(alchimist);
        alchimist.getAuhtors().add(paulo);

        authorRepository.save(paulo);
        bookRepository.save(alchimist);

        System.out.println("Started in bootstrap");
        System.out.println("Number of the books: " + bookRepository.count());

    }
}
