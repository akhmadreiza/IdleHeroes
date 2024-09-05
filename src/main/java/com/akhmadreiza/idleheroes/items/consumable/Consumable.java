package com.akhmadreiza.idleheroes.items.consumable;

import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.items.Item;

public abstract class Consumable implements Item {
    @Override
    public ItemType getItemType() {
        return ItemType.CONSUMABLES;
    }

    public abstract int getHealPoint();
}
