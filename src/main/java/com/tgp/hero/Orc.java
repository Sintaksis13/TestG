package com.tgp.hero;

import com.tgp.arena.Arena;
import com.tgp.enemy.NormalMercenary;
import com.tgp.enemy.WeakMercenary;

import java.io.IOException;
import java.util.Scanner;

public class Orc {
    private int attack = 5;
    private int health = 50;

    public void toArena() throws IOException {
        int oldHealth = health;
        System.out.println("С каким типом людей вы хотите сразиться?\n1. Слабый\n2. Средний\n3. Выйти");
        System.out.print("\nВаш выбор: ");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 1) {
            Arena.getInstance().fight(this, new WeakMercenary(this));
        } else if (choice == 2) {
            Arena.getInstance().fight(this, new NormalMercenary(this));
        } else {
            System.exit(0);
        }

        health = oldHealth;
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

    @Override
    public String toString() {
        return "Игрок";
    }
}
