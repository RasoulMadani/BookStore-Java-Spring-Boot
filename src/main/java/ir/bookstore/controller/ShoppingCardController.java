package ir.bookstore.controller;

import ir.bookstore.dto.request.ShoppingCardRequest;
import ir.bookstore.dto.response.ShoppingCardResponse;
import ir.bookstore.service.shoppingCard.ShoppingCardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCard")
public class ShoppingCardController {
    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }
    @PostMapping
    public ResponseEntity<ShoppingCardResponse> addBook(@RequestBody @Valid ShoppingCardRequest shoppingCardRequest){
       return ResponseEntity.ok(shoppingCardService.addShoppingCard(shoppingCardRequest));
    }

}
