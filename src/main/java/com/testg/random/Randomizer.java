package com.testg.random;

import java.util.Random;

public class Randomizer {
    private static final Randomizer instance = new Randomizer();
    private final Random random;

    private Randomizer() {
        random = new Random();
    }

    public static Randomizer getInstance() {
        return instance;
    }

    public boolean random(double chance) {
        return random.nextDouble() <= chance;
    }

    public boolean throwCoin() {
        boolean result = false;
        for (int i = 0; i < random.nextInt(10) + 5; i++) {
            result = random.nextBoolean();
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
