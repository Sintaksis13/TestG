package com.tgp.training;

import com.tgp.hero.Orc;

public class TrainingCamp {
    private static final TrainingCamp instance = new TrainingCamp();
    private static final int INCREASE_ATTACK_COST = 20;
    private static final int INCREASE_ATTACK_VALUE = 1;

    public static TrainingCamp getInstance() {
        return instance;
    }

    public void increaseAttack(Orc hero) {
        if (hero.getGold() < INCREASE_ATTACK_COST) {
            System.err.println("Недостаточно золота для улучшения!");
            return;
        }
        hero.changeHeroGold(-INCREASE_ATTACK_COST);
        hero.setAttack(hero.getAttack() + INCREASE_ATTACK_VALUE);
        System.err.println("\n" + hero.getName() + " увеличил количество атаки на " + INCREASE_ATTACK_VALUE +
                " за " + INCREASE_ATTACK_COST + " золота\n");
    }
}
