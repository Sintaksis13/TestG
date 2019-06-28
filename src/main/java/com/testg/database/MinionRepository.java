package com.testg.database;

import com.testg.cards.creatures.Minion;
import org.springframework.data.repository.CrudRepository;

public interface MinionRepository extends CrudRepository<Minion, Integer> {
}
