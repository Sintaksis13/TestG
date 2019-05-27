package com.testg.cards;

public abstract class Card {
    private byte cost;

    public Card(byte cost) {
        this.cost = cost;
    }

    public byte getCost() {
        return cost;
    }

    public void setCost(byte cost) {
        this.cost = cost;
    }
}
