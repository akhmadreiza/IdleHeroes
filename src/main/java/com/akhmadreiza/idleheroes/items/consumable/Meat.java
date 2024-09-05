package com.akhmadreiza.idleheroes.items.consumable;

import lombok.Getter;
import lombok.Setter;

public class Meat extends Consumable {
    private static final String MEAT = "Meat";
    private static final int HEAL_PTS = 10;

    @Setter
    @Getter
    private int qty;

    public Meat() {
        this.qty = 1;
    }

    public Meat(int qty) {
        this.qty = qty;
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
