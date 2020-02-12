package io.games.simple.webapp.controller;

import io.games.simple.webapp.dto.UserToLeaderboardDto;
import io.games.simple.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LeaderboardController {

    @Autowired
    private UserService userService;

    @GetMapping("/leaderboard")
    public String getLeaderboard(){
        return "leaderboard";
    }

    @GetMapping("/leader")
    @ResponseBody
    public List<UserToLeaderboardDto> getLeader(){
       return userService.getAllSortedByWinLoseRatio();
    }
}
