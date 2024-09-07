package com.akhmadreiza.idleheroes.items.consumable;

import com.akhmadreiza.idleheroes.items.Craftable;

public abstract class Potion extends Consumable implements Craftable {
    public Potion() {
        super();

    }

    public Potion(int qty) {
        super(qty);
    }
}
