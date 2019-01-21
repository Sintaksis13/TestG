package com.tgp.arena;

import com.tgp.enemy.Mercenary;
import com.tgp.hero.Orc;

import java.util.Random;

public class Arena {
    private Random random = new Random();
    private static final Arena instance = new Arena();

    public static Arena getInstance() {
        return instance;
    }

    public void fight(Orc hero, Mercenary enemy) {
        int heroStartHealth = hero.getHealth();
        int enemyStartHealth = enemy.getHealth();
        boolean heroAttackFirst = isHeroAttackFirst();
        System.out.println((heroAttackFirst ? hero : enemy) + " атакует первым.\n");
        for (int i = 1; i <= 5; i++) {
            processRound(hero, enemy, heroAttackFirst, i);
            if (hero.getHealth() <= 0 || enemy.getHealth() <= 0) {
                break;
            }
        }

        System.out.println("Бой окончен! Победил " +
                ((heroStartHealth - hero.getHealth()) < (enemyStartHealth - enemy.getHealth()) ? hero : enemy) + "\n\n");
    }

    private boolean isHeroAttackFirst() {
        return random.nextInt(2) == 1;
    }

    private void processRound(Orc hero, Mercenary enemy, boolean heroAttackFirst, int roundNumber) {
        System.out.println("\n" + roundNumber + "-й раунд!\n");

        if (heroAttackFirst) {
            enemy.setHealth(attackResult(hero.toString(), hero.getAttack(), enemy.getHealth()));
            hero.setHealth(attackResult(enemy.toString(), enemy.getAttack(), hero.getHealth()));
        } else {
            hero.setHealth(attackResult(enemy.toString(), enemy.getAttack(), hero.getHealth()));
            enemy.setHealth(attackResult(hero.toString(), hero.getAttack(), enemy.getHealth()));
        }
    }

    private int attackResult(String attacker, int damage, int targetHealth) {
        int resultHealth = targetHealth - damage;
        System.out.println(attacker + " нанёс урон " + damage + " и оставил у оппонента " + resultHealth + " здоровья!");
        return resultHealth;
    }
}
