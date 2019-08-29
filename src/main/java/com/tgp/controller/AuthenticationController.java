package com.tgp.controller;

import com.tgp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("player")
public class AuthenticationController {
    private PlayerService playerService;

    @Autowired
    public AuthenticationController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("create")
    public String createNewPlayer(@NotNull String login, @NotNull String password,
                                                  @NotNull String email, Model model) {
        return "register";
    }

    @PostMapping("auth")
    public String authPlayer(Model model, String login, String password) {
        ResponseEntity<String> response = playerService.checkPlayerForAuth(login, password);
        model.addAttribute("authMessage", response.getBody());
        return response.getStatusCode().isError() ? "login" : "main";
    }
}
