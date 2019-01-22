package com.tgp.enemy;

import com.tgp.hero.Orc;

import java.util.Random;

public class WeakMercenary extends Mercenary {
    private static final int WEAK_MERCENARY_REWARD_AMOUNT = 5;

    public WeakMercenary(Orc hero) {
        super(new Random().nextInt(hero.getAttack()), new Random().nextInt(hero.getHealth()));
    }

    public int getRewardAmount() {
        return WEAK_MERCENARY_REWARD_AMOUNT;
    }
}
