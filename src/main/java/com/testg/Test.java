package com.testg;

import com.testg.character.Hero;
import com.testg.manager.FightManager;

public class Test {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Gilbert");
        Hero hero2 = new Hero("Yanush");
        FightManager.getInstance().processFight(hero1, hero2);
    }
}
