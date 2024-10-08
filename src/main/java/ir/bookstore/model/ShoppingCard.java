package ir.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCard extends BaseEntity{
    private int count;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Factor factor;
}
