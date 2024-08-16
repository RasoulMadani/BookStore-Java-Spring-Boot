package ir.bookstore.service.user;

import ir.bookstore.dto.request.UserLoginRequest;
import ir.bookstore.dto.request.UserRequest;
import ir.bookstore.dto.response.UserResponse;
import ir.bookstore.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse save(UserRequest user);

    void login(UserLoginRequest userLoginRequest);

    void changeEnable(Boolean enable, Long id);

    Page<User> findAll(Pageable pageable);
}
