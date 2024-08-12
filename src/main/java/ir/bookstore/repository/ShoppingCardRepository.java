package ir.bookstore.repository;

import ir.bookstore.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Long> {
}
