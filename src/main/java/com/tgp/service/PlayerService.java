package com.tgp.service;

import com.tgp.entity.Player;
import com.tgp.entity.transport.PlayerAuthData;
import com.tgp.repository.PlayerRepository;
import com.tgp.service.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public boolean createNewPlayer(Player player) {
        Player dbPlayer = repository.findByLoginOrEmail(player.getLogin(), player.getEmail());
        if (dbPlayer != null) {
            return false;
        }

        repository.save(player);
        return true;
    }

    public ServiceResponse<Player> authenticatePlayer(@NonNull PlayerAuthData data) {
        ServiceResponse<Player> response;
        Player dbPlayer = repository.findByLogin(data.getLogin());
        if (dbPlayer == null) {
            response = new ServiceResponse<>(null, "", HttpStatus.NOT_FOUND);
        } else if (!dbPlayer.getPassword().equals(data.getPassword())) {
            response = new ServiceResponse<>(dbPlayer, "", HttpStatus.BAD_REQUEST);
        } else {
            response = new ServiceResponse<>(dbPlayer, "", HttpStatus.OK);
        }

        return response;
    }
}
