package dev.hunghh.bookstoretdd.service;

import dev.hunghh.bookstoretdd.dto.BookDto;
import dev.hunghh.bookstoretdd.model.Book;
import dev.hunghh.bookstoretdd.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper){
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getBooks() {
        Iterable<Book> books = bookRepository.findAll();
        return StreamSupport.stream(books.spliterator(), false)
                .map(convertBookToBookDto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookToBookDto() {
        return book -> modelMapper.map(book, BookDto.class);
    }
}
