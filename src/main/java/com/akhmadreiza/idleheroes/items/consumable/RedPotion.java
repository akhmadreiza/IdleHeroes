package com.akhmadreiza.idleheroes.items.consumable;

import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.items.Item;
import com.akhmadreiza.idleheroes.items.craft.Bottle;
import com.akhmadreiza.idleheroes.items.craft.RedHerbs;

import java.util.Map;

public class RedPotion extends Potion {

    public RedPotion() {
        super();
    }

    public RedPotion(int qty) {
        super(qty);
    }

    @Override
    public boolean ableToCraft(PlayerModifier playerModifier) {
        if (playerModifier.getInventory().values().isEmpty()) {
            return false;
        }

        Map<String, Integer> recipeMap = getRecipe();
        for (String recipeItem : recipeMap.keySet()) {
            Map<String, Item> inventoryMap = playerModifier.getInventory();
            return inventoryMap.containsKey(recipeItem) && inventoryMap.get(recipeItem).getQty() == recipeMap.get(recipeItem);
        }

        return false;
    }

    @Override
    public Map<String, Integer> getRecipe() {
        RedHerbs redHerbs = new RedHerbs(2);
        Bottle bottle = new Bottle(1);
        return Map.of(redHerbs.getName(), redHerbs.getQty(), bottle.getName(), bottle.getQty());
    }

    @Override
    public int getHealPoint() {
        return 25;
    }

    @Override
    public String getName() {
        return "Red Potion";
    }
}
