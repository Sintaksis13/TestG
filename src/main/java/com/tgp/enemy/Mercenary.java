package com.tgp.enemy;

public abstract class Mercenary {
    private int attack;
    private int health;

    public Mercenary(int attack, int health) {
        this.attack = attack;
        this.health = health;
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
