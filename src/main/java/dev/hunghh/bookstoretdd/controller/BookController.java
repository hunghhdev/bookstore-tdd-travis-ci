package dev.hunghh.bookstoretdd.controller;

import dev.hunghh.bookstoretdd.dto.BookDto;
import dev.hunghh.bookstoretdd.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }
}
