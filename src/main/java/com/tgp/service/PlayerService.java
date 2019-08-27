package com.tgp.service;

import com.tgp.entity.Player;
import com.tgp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public boolean createNewPlayer(Player player) {
        Player dbPlayer = repository.findByUserNameOrEmail(player.getUserName(), player.getEmail());
        if (dbPlayer != null) {
            return false;
        }

        repository.save(player);
        return true;
    }
}
