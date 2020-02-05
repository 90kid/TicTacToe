package io.games.simple.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainViewController {


    @GetMapping(value = {"/mainView", "/"})
    public String renderMainView(){

        return "mainView";
    }
}
