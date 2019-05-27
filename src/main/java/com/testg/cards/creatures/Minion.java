package com.testg.cards.creatures;

import com.testg.cards.Card;
import com.testg.cards.effects.Effect;

import java.util.Arrays;
import java.util.List;

public abstract class Minion extends Card {
    private long currentHP;
    private long baseHP;
    private long currentAP;
    private long baseAP;
    private boolean canAttack;
    private List<Effect> effects;

    public Minion(byte cost, long healthPoints, long attackPoints, boolean canAttack, Effect... effects) {
        super(cost);
        this.currentHP = healthPoints;
        this.baseHP = healthPoints;
        this.currentAP = attackPoints;
        this.baseAP = attackPoints;
        this.canAttack = canAttack;
        this.effects = Arrays.asList(effects);
    }

    public long getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(long currentHP) {
        this.currentHP = currentHP;
    }

    public long getCurrentAP() {
        return currentAP;
    }

    public void setCurrentAP(long currentAP) {
        this.currentAP = currentAP;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public long getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(long baseHP) {
        this.baseHP = baseHP;
    }

    public long getBaseAP() {
        return baseAP;
    }

    public void setBaseAP(long baseAP) {
        this.baseAP = baseAP;
    }
}
