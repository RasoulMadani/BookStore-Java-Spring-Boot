package ir.bookstore.service.shoppingCard;

import ir.bookstore.dto.request.ShoppingCardRequest;
import ir.bookstore.dto.response.ShoppingCardResponse;
import ir.bookstore.exception.RuleException;
import ir.bookstore.model.*;
import ir.bookstore.repository.BookRepository;
import ir.bookstore.repository.FactorRepository;
import ir.bookstore.repository.ShoppingCardRepository;
import ir.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService{
    private final FactorRepository factorRepository;
    private final ShoppingCardRepository shoppingCardRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    public ShoppingCardServiceImpl(FactorRepository factorRepository, ShoppingCardRepository shoppingCardRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.factorRepository = factorRepository;
        this.shoppingCardRepository = shoppingCardRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest) {
        User user = userRepository.findById(shoppingCardRequest.getUserId())
                    .orElseThrow(() -> new RuleException("user.not.exist"));
        Book book = bookRepository.findById(shoppingCardRequest.getBookId())
                .orElseThrow(() -> new RuleException("book.not.found"));
        Optional<Factor> factor = factorRepository.findByUserAndPayed(user, Payed.UNPAYED);
        Factor factor1;
        factor1 = factor.orElseGet(() -> createFactor(user));
        factorRepository.save(factor1);

        ShoppingCard shoppingCard = getBuild(shoppingCardRequest, book, factor1);
        return createShoppingCardResponse(shoppingCardRepository.save(shoppingCard));
    }

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard) {
        return ShoppingCardResponse.builder()
                .factorId(shoppingCard.getFactor().getId())
                .shoppingCard(shoppingCard.getId())
                .build();
    }

    private Factor createFactor(User user) {
       return Factor.builder()
                .user(user)
                .payed(Payed.UNPAYED)
                .build();
    }

    private ShoppingCard getBuild(ShoppingCardRequest shoppingCardRequest, Book book, Factor factor) {
        return ShoppingCard.builder().book(book)
                .factor(factor)
                .count(shoppingCardRequest.getCount())
                .build();
    }
}
