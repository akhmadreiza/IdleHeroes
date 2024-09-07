package com.akhmadreiza.idleheroes.items.consumable;

public class Meat extends Consumable {
    private static final String MEAT = "Meat";
    private static final int HEAL_PTS = 10;

    public Meat(int qty) {
        super(qty);
    }

    @Override
    public String getName() {
        return MEAT;
    }

    @Override
    public int getHealPoint() {
        return HEAL_PTS;
    }
}
