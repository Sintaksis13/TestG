package com.testg.manager;

import com.testg.character.Character;
import com.testg.random.Randomizer;

public class FightManager {
    private static final FightManager instance = new FightManager();

    private FightManager() {
    }

    public static FightManager getInstance() {
        return instance;
    }

    public void processFight(Character firstPlayer, Character secondPlayer) {
        Character first;
        Character second;
        if (isFirstAttackFirst()) {
            first = firstPlayer;
            second = secondPlayer;
        } else {
            first = secondPlayer;
            second = firstPlayer;
        }

        while (first.isAlive() && second.isAlive()) {
            System.out.print("1 atk 2 with " + first.getAttackPoints() + " and");
            boolean firstHit = isTargetHit(second.getAvoidChance());
            System.out.println(firstHit ? " hit!" : " missed!");
            if (firstHit) {
                second.setHealthPoints(second.getHealthPoints() - first.getAttackPoints());
                if (!second.isAlive()) {
                    continue;
                }
            }

            System.out.print("2 atk 1 with " + second.getAttackPoints() + " and");
            boolean secondHit = isTargetHit(first.getAvoidChance());
            System.out.println(secondHit ? " hit!" : " missed!");
            if (secondHit) {
                first.setHealthPoints(first.getHealthPoints() - second.getAttackPoints());
            }

            System.out.println("\nState:\nFirst = " + first + "\nSecond = " + second);
        }

        System.out.println("\n\nThe winner is " + (first.isAlive() ? first.getName() : second.getName()) + ". Congrats!");
    }

    private boolean isTargetHit(double avoidChance) {
        return Randomizer.getInstance().random(avoidChance);
    }

    private boolean isFirstAttackFirst() {
        return Randomizer.getInstance().throwCoin();
    }
}

