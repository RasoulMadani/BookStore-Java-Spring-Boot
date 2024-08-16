package ir.bookstore.service.user;

import ir.bookstore.dto.request.UserLoginRequest;
import ir.bookstore.dto.request.UserRequest;
import ir.bookstore.dto.response.UserResponse;
import ir.bookstore.exception.RuleException;
import ir.bookstore.model.User;
import ir.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if(byUsername.isPresent())
            throw  new RuleException("username.is.exist");
        return createUserResponse(userRepository.save(getBuildUser(userRequest)));
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(() -> new RuleException("user.not.found"));
        if(!user.getPassword().equals(userLoginRequest.getPassword())){
            throw new RuleException("user.not.found");
        }
    }

    private static User getBuildUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .username(userRequest.getUsername()).build();
    }

    private UserResponse createUserResponse(User saveUser) {
        return UserResponse.builder()
                .id(saveUser.getId())
                .username(saveUser.getUsername())
                .build();
    }
}
