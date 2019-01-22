package com.tgp.arena;

import com.tgp.enemy.Mercenary;
import com.tgp.enemy.NormalMercenary;
import com.tgp.enemy.WeakMercenary;
import com.tgp.exceptions.QuitException;
import com.tgp.hero.Orc;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    private Random random = new Random();
    private static final Arena instance = new Arena();

    public static Arena getInstance() {
        return instance;
    }

    public void enterArena(Orc hero) throws QuitException {
        int oldHealth = hero.getHealth();
        System.out.println("С каким типом людей вы хотите сразиться?\n1. Слабый\n2. Средний\n3. Выйти\n");
        System.out.print("\nВаш выбор: ");
        int choice = new Scanner(System.in).nextInt();
        fight(hero, choice);
        hero.setHealth(oldHealth);
    }

    private void fight(Orc hero, int choice) throws QuitException {
        Mercenary enemy;
        switch (choice) {
            case 1: {
                enemy = new WeakMercenary(hero);
                break;
            }
            case 2: {
                enemy = new NormalMercenary(hero);
                break;
            }
            default: throw new QuitException();
        }
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

        boolean heroWin = (heroStartHealth - hero.getHealth()) < (enemyStartHealth - enemy.getHealth());
        System.out.println("Бой окончен! Победил " + (heroWin ? hero.getName() : enemy.getName()) + "\n\n");
        if (heroWin) {
            hero.changeHeroGold(enemy.getRewardAmount());
        }
    }

    private boolean isHeroAttackFirst() {
        return random.nextInt(2) == 1;
    }

    private void processRound(Orc hero, Mercenary enemy, boolean heroAttackFirst, int roundNumber) {
        System.out.println("\n" + roundNumber + "-й раунд!\n");

        if (heroAttackFirst) {
            enemy.setHealth(attackResult(hero.getName(), hero.getAttack(), enemy.getHealth()));
            hero.setHealth(attackResult(enemy.getName(), enemy.getAttack(), hero.getHealth()));
        } else {
            hero.setHealth(attackResult(enemy.getName(), enemy.getAttack(), hero.getHealth()));
            enemy.setHealth(attackResult(hero.getName(), hero.getAttack(), enemy.getHealth()));
        }
    }

    private int attackResult(String attacker, int damage, int targetHealth) {
        int resultHealth = targetHealth - damage;
        System.out.println(attacker + " нанёс урон " + damage + " и оставил у оппонента " + resultHealth + " здоровья!");
        return resultHealth;
    }
}
