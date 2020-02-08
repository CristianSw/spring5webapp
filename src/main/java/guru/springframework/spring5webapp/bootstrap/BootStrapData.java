package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {

        Publisher indrivo = new Publisher("Indrivo", "Stefan cel Mare 14", "Chisinau", "Centru", "MD-2001");
        publisherRepository.save(indrivo);
        Publisher librarius = new Publisher("Librarius", "Calea Iesilor 10", "Chisinau", "Sculeanca", "MD-2006");
        publisherRepository.save(librarius);
        Publisher elefant = new Publisher("Elefant MD", "Grigorie Vieru", "Chisinau", "Centru", "MD-2001");
        publisherRepository.save(elefant);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuhtors().add(eric);
        ddd.setPublisher(indrivo);
        indrivo.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(indrivo);

        Author ron = new Author("Ron", "Jonson");
        Book noEJB = new Book("J2EE Development with EJB", "123642");

        ron.getBooks().add(noEJB);
        noEJB.getAuhtors().add(ron);
        noEJB.setPublisher(librarius);
        librarius.getBooks().add(noEJB);

        authorRepository.save(ron);
        bookRepository.save(noEJB);
        publisherRepository.save(librarius);

        Author paulo = new Author("Paulo", "Coelho");
        Book alchemist = new Book("The Alchemist", "12321546");

        paulo.getBooks().add(alchemist);
        alchemist.getAuhtors().add(paulo);
        alchemist.setPublisher(elefant);
        elefant.getBooks().add(alchemist);

        authorRepository.save(paulo);
        bookRepository.save(alchemist);
        publisherRepository.save(elefant);

        System.out.println("Started in bootstrap");
        System.out.println("Number of the books: " + bookRepository.count());
        System.out.println("Publishers: " + publisherRepository.count());
        System.out.println("Publisher Indrivo: " + indrivo.getBooks().size());
        System.out.println("Publisher Librarius: " + librarius.getBooks().size());
        System.out.println("Publisher Elefant MD: " + elefant.getBooks().size());
    }
}
