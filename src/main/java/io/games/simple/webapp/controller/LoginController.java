package io.games.simple.webapp.controller;


import io.games.simple.webapp.entity.UserEntity;
import io.games.simple.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String logInPage(){
        return "login";
    }

    //Code below to erase. It purpose is to fast add test user to DB
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired UserService service;

    @ResponseBody
    @GetMapping("/save")
    public UserEntity saveUser(){
    UserEntity user = UserEntity.builder()
                .id(1)
                .email("tomek@poczta.pl")
                .password(passwordEncoder.encode("tomek"))
                .enabled(true)
                .build();
        service.save(user);
        return user;
    }
}
