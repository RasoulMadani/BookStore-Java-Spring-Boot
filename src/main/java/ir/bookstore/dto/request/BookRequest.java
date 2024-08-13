package ir.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BookRequest {
    @NotNull(message = "{book.name.is.null}")
    @NotBlank(message = "{book.name.is.blank}")
    private final String name;

    @NotNull(message = "{book.price.is.null}")
    @Min(value = 0,message = "{price.min}")
    private final Long currency;
}
