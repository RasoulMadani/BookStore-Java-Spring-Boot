package ir.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted is null")
public class Book extends BaseEntity{ 
    private String name;
    private long price;

}
