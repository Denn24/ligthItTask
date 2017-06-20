package it.navigator.service;

import it.navigator.entity.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Dimas on 18.06.2017.
 */
public interface UserService  extends UserDetailsService {
    User findUserByLogin(String login);

    User findUserById(Long id);

    void registerUser(User newUser);
}
