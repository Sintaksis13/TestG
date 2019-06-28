package com.testg.cards.creatures;

import com.testg.cards.Card;

import javax.persistence.Entity;

@Entity
public class Minion extends Card {
    private int hp;
    private int ap;
    private String name;

    public Minion() {
    }

    public Minion(String name, int ap, int hp, byte cost) {
        super(cost);
        this.name = name;
        this.ap = ap;
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Minion[name = '%s', ap = '%d', hp = '%d', cost = '%d']", name, ap, hp, getCost());
    }
}
