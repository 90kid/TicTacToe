package io.games.simple.webapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class OwnErrorController implements ErrorController {

    @RequestMapping("/error")
    public String errorHandling(HttpServletRequest request, Model model){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = "default";
        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                message = "404 not found";
            }
        }
        model.addAttribute("errorMessage", message);
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
