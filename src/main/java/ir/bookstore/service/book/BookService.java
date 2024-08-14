package ir.bookstore.service.book;

import ir.bookstore.dto.request.BookRequest;
import ir.bookstore.dto.response.BookResponse;
import ir.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BookService {
    BookResponse save (BookRequest bookRequest);

    Page<BookResponse> findAll(Pageable pageable);

    List<BookResponse> findByName(String name);

    BookResponse findById(Long id);
}
