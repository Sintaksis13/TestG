package com.tgp.repositories;

import com.tgp.domain.players.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
