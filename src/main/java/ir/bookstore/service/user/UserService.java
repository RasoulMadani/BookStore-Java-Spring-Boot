package ir.bookstore.service.user;

import ir.bookstore.dto.response.UserResponse;
import ir.bookstore.model.User;

public interface UserService {
    UserResponse save(User user);
}
