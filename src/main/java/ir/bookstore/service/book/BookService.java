package ir.bookstore.service.book;

import ir.bookstore.dto.request.BookRequest;
import ir.bookstore.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookService {
    BookResponse save (BookRequest bookRequest);

    Page<BookResponse> findAll(Pageable pageable);
}
