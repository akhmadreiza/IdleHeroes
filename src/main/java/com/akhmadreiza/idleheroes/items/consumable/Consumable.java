package com.akhmadreiza.idleheroes.items.consumable;

import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.items.Item;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Consumable implements Item {
    private int qty;

    public Consumable() {
    }

    public Consumable(int qty) {
        this.qty = qty;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.CONSUMABLES;
    }

    public abstract int getHealPoint();
}
