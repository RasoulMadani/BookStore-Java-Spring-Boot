package ir.bookstore.service.book;

import ir.bookstore.dto.request.BookRequest;
import ir.bookstore.dto.response.BookResponse;
import ir.bookstore.exception.RuleException;
import ir.bookstore.model.Book;
import ir.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map((book)->BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build());
    }

    @Override
    public List<BookResponse> findByName(String name) {
       return bookRepository.findByNameContains(name)
                .stream().map((book -> BookResponse.builder()
                        .name(book.getName())
                        .id(book.getId())
                        .price(book.getPrice()).build()
                )).collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
        Book book = getBook(id);
        return createBookResponse(book);
    }

    private Book getBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuleException("book.not.found"));
        return book;
    }

    @Override
    public void deleted(Long id) {
        Book byId = getBook(id);
        bookRepository.delete(byId);
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
