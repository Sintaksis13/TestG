package com.tgp.hero;

import com.tgp.arena.Arena;
import com.tgp.exceptions.QuitException;

public class Orc {
    private int attack = 5;
    private int health = 50;
    private long gold = 100;
    private String name = "Игрок";

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
