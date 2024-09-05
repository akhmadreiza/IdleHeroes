package com.akhmadreiza.idleheroes.items.craft;

import lombok.Getter;
import lombok.Setter;

public class AnimalSkin extends Resource {
    private static final String ANIMAL_SKIN = "Animal Skin";

    @Setter
    @Getter
    private int qty;

    public AnimalSkin(int qty) {
        this.qty = qty;
    }

    @Override
    public String getName() {
        return ANIMAL_SKIN;
    }
}
