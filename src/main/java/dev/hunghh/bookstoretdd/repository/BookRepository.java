package dev.hunghh.bookstoretdd.repository;

import dev.hunghh.bookstoretdd.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {
    List<Book> findBooksByTitleAndDescription(String title, String desc);
}
