package app.repositories;

import org.springframework.data.repository.CrudRepository;
import app.springboot.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
