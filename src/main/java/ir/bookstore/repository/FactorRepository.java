package ir.bookstore.repository;

import ir.bookstore.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorRepository extends JpaRepository<Factor,Long> {
}
