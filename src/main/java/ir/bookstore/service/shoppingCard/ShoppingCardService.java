package ir.bookstore.service.shoppingCard;

import ir.bookstore.dto.request.ShoppingCardRequest;
import ir.bookstore.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {
    ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest);
}
