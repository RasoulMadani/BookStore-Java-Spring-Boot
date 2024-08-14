package ir.bookstore.controller;

import ir.bookstore.dto.request.BookRequest;
import ir.bookstore.dto.response.BookResponse;
import ir.bookstore.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private  final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest bookRequest){
        return ResponseEntity.ok(bookService.save(bookRequest));
    }
    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable){
        return ResponseEntity.ok(bookService.findAll(pageable));
    }

}
