package ir.bookstore.service.user;

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
    public User save(User user) {
        Optional<User> byUsername = userRepository.findByUsername(user.getUsername());
        if(byUsername.isPresent())throw  new RuleException("username.is.exist");
        return userRepository.save(user);
    }
}
