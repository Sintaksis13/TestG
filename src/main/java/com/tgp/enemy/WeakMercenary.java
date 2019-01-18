package com.tgp.enemy;

import com.tgp.hero.Orc;

import java.util.Random;

public class WeakMercenary extends Mercenary {
    public WeakMercenary(Orc hero) {
        super(new Random().nextInt(hero.getAttack()), new Random().nextInt(hero.getHealth()));
    }
}
