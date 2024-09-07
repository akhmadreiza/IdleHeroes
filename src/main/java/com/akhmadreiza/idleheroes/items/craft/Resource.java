package com.akhmadreiza.idleheroes.items.craft;

import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.items.Item;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Resource implements Item {
    private int qty;

    public Resource(int qty) {
        this.qty = qty;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.RESOURCES;
    }
}
