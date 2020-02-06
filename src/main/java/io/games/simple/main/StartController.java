package io.games.simple.main;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StartController {

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @GetMapping("/")
    public String register(Model model){
        return "register";
    }
}
