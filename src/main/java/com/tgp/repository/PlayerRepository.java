package com.tgp.repository;

import com.tgp.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Player findByLoginOrEmail(String login, String email);
    Player findByLogin(String login);
    Player findByEmail(String email);
}
