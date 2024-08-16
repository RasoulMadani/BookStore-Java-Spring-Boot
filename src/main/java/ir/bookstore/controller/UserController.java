package ir.bookstore.controller;


import ir.bookstore.dto.request.UserLoginRequest;
import ir.bookstore.dto.request.UserRequest;
import ir.bookstore.dto.response.UserResponse;
import ir.bookstore.model.User;
import ir.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(userService.save(userRequest));
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        userService.login(userLoginRequest);
       return ResponseEntity.ok().build();
    }

}
