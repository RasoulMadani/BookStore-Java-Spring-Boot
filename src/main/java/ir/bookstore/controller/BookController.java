package ir.bookstore.controller;

import ir.bookstore.dto.request.BookRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid BookRequest bookRequest){

    }
}
