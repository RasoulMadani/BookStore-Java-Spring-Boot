package ir.bookstore.controller;


import ir.bookstore.dto.request.UserRequest;
import ir.bookstore.dto.response.UserResponse;
import ir.bookstore.model.User;
import ir.bookstore.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.save(userRequest));
    }
}
