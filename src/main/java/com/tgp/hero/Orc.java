package com.tgp.hero;

import com.tgp.arena.Arena;
import com.tgp.exceptions.QuitException;

public class Orc {
    private static final int DEFAULT_ATTACK = 5;
    private static final int DEFAULT_HEALTH = 50;
    private static final long DEFAULT_GOLD_AMOUNT = 100;
    private static final String DEFAULT_NAME = "Игрок";

    private int attack;
    private int health;
    private long gold;
    private String name;

    public Orc() {
        //default constructor
        this.attack = DEFAULT_ATTACK;
        this.health = DEFAULT_HEALTH;
        this.gold = DEFAULT_GOLD_AMOUNT;
        this.name = DEFAULT_NAME;
    }

    public Orc(String name, int health, int attack, long gold) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.gold = gold;
    }

    public void toArena() throws QuitException {
        Arena.getInstance().enterArena(this);
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

    public String getName() {
        return name;
    }

    public long getGold() {
        return gold;
    }

    public void changeHeroGold(int amount) {
        gold = gold + amount;
    }

    @Override
    public String toString() {
        return "Статистика:" +
                "\nИмя: " + name +
                "\nАтака: " + attack +
                "\nЗдоровье: " + health +
                "\nЗолото: " + gold + "\n\n";
    }
}
