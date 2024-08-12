package ir.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class User extends BaseEntity{
    private String username;
    private String password;
}
