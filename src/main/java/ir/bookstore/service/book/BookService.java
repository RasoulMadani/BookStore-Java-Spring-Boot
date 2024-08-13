package ir.bookstore.service.book;

import ir.bookstore.dto.request.BookRequest;
import ir.bookstore.dto.response.BookResponse;

public interface BookService {
    BookResponse save (BookRequest bookRequest);
}
