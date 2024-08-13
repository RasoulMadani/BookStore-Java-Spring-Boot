package ir.bookstore.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class BookResponse {
    private final Long id;
    private final String name;
    private final Long price;
}
