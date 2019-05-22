package com.testg.character;

public class Hero extends Character {
    private static final int DEFAULT_HERO_HEALTH_POINTS = 50;
    private static final int DEFAULT_HERO_ATTACK_POINTS = 10;
    private static final double DEFAULT_HERO_AVOID_CHANCE_PERCENT = 0.1;

    public Hero(String name) {
        super(DEFAULT_HERO_HEALTH_POINTS, DEFAULT_HERO_ATTACK_POINTS, DEFAULT_HERO_AVOID_CHANCE_PERCENT, name);
    }
}
