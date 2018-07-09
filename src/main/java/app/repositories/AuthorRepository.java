package app.repositories;

import org.springframework.data.repository.CrudRepository;
import app.springboot.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
