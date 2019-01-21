package com.tgp.enemy;

import com.tgp.hero.Orc;

import java.util.Random;

public class NormalMercenary extends Mercenary {
    public NormalMercenary(Orc hero) {
        super(new Random().nextInt(hero.getAttack()) + 5, new Random().nextInt(hero.getHealth()) + 10);
    }
}
