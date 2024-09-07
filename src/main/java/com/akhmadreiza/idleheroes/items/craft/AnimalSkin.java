package com.akhmadreiza.idleheroes.items.craft;

public class AnimalSkin extends Resource {
    private static final String ANIMAL_SKIN = "Animal Skin";

    public AnimalSkin(int qty) {
        super(qty);
    }

    @Override
    public String getName() {
        return ANIMAL_SKIN;
    }
}
