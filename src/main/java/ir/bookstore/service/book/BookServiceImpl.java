package ir.bookstore.service.book;

import ir.bookstore.dto.request.BookRequest;
import ir.bookstore.dto.response.BookResponse;
import ir.bookstore.exception.RuleException;
import ir.bookstore.model.Book;
import ir.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName = bookRepository.findByName(bookRequest.getName());
        if(byName.isPresent())
            throw new RuleException("book.is.exist");
        Book book = bookRepository.save(createBook(bookRequest));
        return createBookResponse(book);
    }
    private Book createBook(BookRequest bookRequest){
        return Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getCurrency())
                .build();
    }
    private BookResponse createBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
}
