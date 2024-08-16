package ir.bookstore.repository;

import ir.bookstore.model.Factor;
import ir.bookstore.model.Payed;
import ir.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor,Long> {
    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
