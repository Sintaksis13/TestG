package com.testg.cards.creatures;

import com.testg.cards.Card;

import javax.persistence.Entity;

@Entity
public abstract class Minion extends Card {
    private int hp;
    private int ap;
    private String name;

    public Minion(byte cost) {
        super(cost);
    }

    public Minion(byte cost, int hp, int ap, String name) {
        super(cost);
        this.hp = hp;
        this.ap = ap;
        this.name = name;
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
        return String.format("Minion[name = '%s', hp = '%d', ap = '%d']", name, hp, ap);
    }
}
