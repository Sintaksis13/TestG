package com.tgp.enemy;

import com.tgp.hero.Orc;

import java.util.Random;

public class NormalMercenary extends Mercenary {
    private static final int NORMAL_MERCENARY_REWARD_AMOUNT = 10;

    public NormalMercenary(Orc hero) {
        super(new Random().nextInt(hero.getAttack()) + 5, new Random().nextInt(hero.getHealth()) + 10);
    }

    public int getRewardAmount() {
        return NORMAL_MERCENARY_REWARD_AMOUNT;
    }
}
