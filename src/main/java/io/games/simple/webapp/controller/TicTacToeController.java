package io.games.simple.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicTacToeController {

    @GetMapping("/tictactoe")
    public String renderTicTacToe(){
        return "tictactoe";
    }
}
