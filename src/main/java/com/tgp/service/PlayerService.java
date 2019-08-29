package com.tgp.service;

import com.tgp.entity.Player;
import com.tgp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> getPlayerForAuth(String login, String password) {
        Player dbPlayer = repository.findByLogin(login);
        HttpStatus status = getAuthStatus(dbPlayer, password);
        return new ResponseEntity<>(getAuthMessage(dbPlayer, status), status);
    }

    private String getAuthMessage(Player playerData, HttpStatus status) {
        String message;
        if (status.equals(HttpStatus.OK)) {
            message = "Добро пожаловать, " + playerData.getFullName();
        } else {
            message = "Неверный логин или пароль!";
        }

        return message;
    }

    private HttpStatus getAuthStatus(Player playerData, String password) {
        return playerData != null && playerData.getPassword().equals(password) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
}
