package com.testg.character;

public abstract class Character {
    private int healthPoints;
    private int attackPoints;
    private double avoidChance;
    private String name;

    public Character(int healthPoints, int attackPoints, double avoidChance, String name) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.avoidChance = avoidChance;
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public double getAvoidChance() {
        return avoidChance;
    }

    public void setAvoidChance(double avoidChance) {
        this.avoidChance = avoidChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    @Override
    public String toString() {
        return "Character [" +
                "healthPoints=" + healthPoints +
                ", name=" + name +
                ']';
    }
}
