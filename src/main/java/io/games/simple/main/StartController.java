package io.games.simple.main;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StartController {

    @GetMapping("/")
    public String getPeople(Model model){
        return "login";
    }
}
