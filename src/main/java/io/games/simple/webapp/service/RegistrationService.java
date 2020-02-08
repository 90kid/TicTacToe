package io.games.simple.webapp.service;

import io.games.simple.webapp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired private UserService userService;
    @Autowired private PasswordEncoder passwordEncoder;

    public void register(UserEntity user) {
        user.setLogin(user.getLogin().trim());
        user.setEmail(user.getEmail().trim());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
