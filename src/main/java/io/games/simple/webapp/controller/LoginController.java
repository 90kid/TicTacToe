package io.games.simple.webapp.controller;

import io.games.simple.webapp.entity.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String renderLogin(@AuthenticationPrincipal UserEntity user){
        if(user != null){
            return "redirect:/mainView";
        }
        return "login";
    }
}
