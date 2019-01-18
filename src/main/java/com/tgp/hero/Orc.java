package com.tgp.hero;

import com.tgp.enemy.Mercenary;
import com.tgp.enemy.WeakMercenary;

import java.io.IOException;
import java.util.Random;

public class Orc {
    private int attack = 5;
    private int health = 50;

    public void toArena() throws IOException {
        int oldHealth = health;
        System.out.println("С каким типом людей вы хотите сразиться?\n 1. Слабый\n2. Вернуться назад");
        int choice = System.in.read();
        switch (choice) {
            case 1: fight(new WeakMercenary(this));
            default: System.exit(0);
        }

        health = oldHealth;
    }

    private void fight(Mercenary mercenary) {
        Random random = new Random();
        int chance = random.nextInt(2);
        String whoAttackFirst;
        if (chance == 0) {
            whoAttackFirst = "Игрок";
        } else {
            whoAttackFirst = "Противник";
        }
        int damageToHero = 0;
        int damageToEnemy = 0;
        System.out.println("Первым наносит удар: " + whoAttackFirst);
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "-й раунд!");
            if (chance == 0) {
                mercenary.setHealth(mercenary.getHealth() - attack);

            }
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
