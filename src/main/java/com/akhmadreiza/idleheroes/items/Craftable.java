package com.akhmadreiza.idleheroes.items;

import com.akhmadreiza.idleheroes.controller.PlayerModifier;

import java.util.Map;

public interface Craftable {
    boolean ableToCraft(PlayerModifier playerModifier);

    Map<String, Integer> getRecipe();
}
