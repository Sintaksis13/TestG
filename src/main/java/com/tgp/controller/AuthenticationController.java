package com.tgp.controller;

import com.tgp.entity.Player;
import com.tgp.entity.transport.PlayerAuthData;
import com.tgp.service.PlayerService;
import com.tgp.service.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class AuthenticationController {
    private PlayerService playerService;

    @Autowired
    public AuthenticationController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> createNewPlayer(@RequestBody Player player) {
        boolean created = playerService.createNewPlayer(player);
        return created ? ResponseEntity.ok(player) : ResponseEntity.badRequest().body(player);
    }

    @PostMapping("auth")
    public ResponseEntity<Player> authPlayer(@RequestBody PlayerAuthData authData) {
        ServiceResponse<Player> response = playerService.authenticatePlayer(authData);
        return new ResponseEntity<>(response.getObject(), response.getStatus());
    }
}
