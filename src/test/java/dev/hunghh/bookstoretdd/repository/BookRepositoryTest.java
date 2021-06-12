package dev.hunghh.bookstoretdd.repository;

import dev.hunghh.bookstoretdd.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldAbleToFetchAllBooksInDB() {
        Iterable<Book> books = bookRepository.findAll();
        long totalBookCount = StreamSupport.stream(books.spliterator(), false).count();
        Assertions.assertEquals(2, totalBookCount);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldReturnOneBookWhenTitleIsTestTitle(){
        List<Book> test_title = bookRepository.findBooksByTitle("test title");
        Assertions.assertEquals(1, test_title.size());
    }
}
