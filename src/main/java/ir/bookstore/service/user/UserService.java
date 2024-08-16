package ir.bookstore.service.user;

import ir.bookstore.dto.request.UserLoginRequest;
import ir.bookstore.dto.request.UserRequest;
import ir.bookstore.dto.response.UserResponse;
import ir.bookstore.model.User;

public interface UserService {
    UserResponse save(UserRequest user);

    void login(UserLoginRequest userLoginRequest);
}
