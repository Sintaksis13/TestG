package com.tgp.controller;

import com.tgp.domain.players.Player;
import com.tgp.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    private final PlayerRepository playerRepository;

    @Autowired
    public MainController(PlayerRepository repo) {
        this.playerRepository = repo;
    }

    @RequestMapping("/main")
    public String main(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "main";
    }

    @RequestMapping
    public String index(Map<String, Object> model) {
        Iterable<Player> allPlayers = playerRepository.findAll();

        model.put("players", allPlayers);

        return "index";
    }
}
