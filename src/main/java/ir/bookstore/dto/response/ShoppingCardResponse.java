package ir.bookstore.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@RequiredArgsConstructor
@Builder
public class ShoppingCardResponse {
    private final Long shoppingCard;
    private final Long factorId;
}
