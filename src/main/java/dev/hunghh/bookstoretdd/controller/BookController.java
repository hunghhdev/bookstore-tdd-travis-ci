package dev.hunghh.bookstoretdd.controller;

import dev.hunghh.bookstoretdd.dto.BookDto;
import dev.hunghh.bookstoretdd.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "Book Api", tags = "Book Api", produces = "application.json")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Resource
    private BookService bookService;

    @ApiOperation(value = "get list of books", response = BookDto[].class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of book"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "not found resource")
    })
    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<BookDto>> getBooksByTitle(@PathVariable String title) {
        var books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(books);
    }
}
