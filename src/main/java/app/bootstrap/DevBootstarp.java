package app.bootstrap;

import app.repositories.AuthorRepository;
import app.repositories.BookRepository;
import app.repositories.PublisherRepository;
import app.springboot.Author;
import app.springboot.Book;
import app.springboot.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstarp implements ApplicationListener <ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstarp(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    public void initData(){
        Author antoine = new Author("Antoine", "de Saint Exupery");
        Publisher rAndH = new Publisher("Reynal & Hitchcock", "NYC, USA");
        Book tlp = new Book("The Little Prince", "1", rAndH);
        antoine.getBooks().add(tlp);
        tlp.getAuthors().add(antoine);

        publisherRepository.save(rAndH);
        authorRepository.save(antoine);
        bookRepository.save(tlp);


        Author george = new Author("George", "Orwell");
        Publisher sAndW = new Publisher("Secker and Warburg", "London, UK");
        Book af = new Book("Animal Farm", "2", sAndW);
        george.getBooks().add(af);
        af.getAuthors().add(george);

        publisherRepository.save(sAndW);
        authorRepository.save(george);
        bookRepository.save(af);
    }
}
