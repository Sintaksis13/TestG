package com.tgp.enemy;

public abstract class Mercenary {
    private int attack;
    private int health;

    Mercenary(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    public abstract int getRewardAmount();

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return "Противник";
    }
}
