package io.games.simple.main;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/")
    public String login(){
        return "login";
    }
}
