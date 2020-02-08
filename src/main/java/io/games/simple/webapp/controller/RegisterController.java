package io.games.simple.webapp.controller;


import io.games.simple.webapp.entity.UserEntity;
import io.games.simple.webapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String renderRegister(Model model, @AuthenticationPrincipal UserEntity user){
        if(user != null){ return "redirect:/mainView";}
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid UserEntity user){
        registrationService.register(user);
        return "/login";
    }
}
