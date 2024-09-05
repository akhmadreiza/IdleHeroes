package com.akhmadreiza.idleheroes.items.craft;

import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.items.Item;

public abstract class Resource implements Item {
    @Override
    public ItemType getItemType() {
        return ItemType.RESOURCES;
    }
}
