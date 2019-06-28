package com.testg.database;

import com.testg.cards.creatures.Minion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MinionRepository extends CrudRepository<Minion, Integer> {
    Minion findByName(String name);
    void deleteByName(String name);
}
