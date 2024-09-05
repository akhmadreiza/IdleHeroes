package com.akhmadreiza.idleheroes.items;

import com.akhmadreiza.idleheroes.constant.ItemType;

public interface Item {
    String getName();
    int getQty();
    ItemType getItemType();
    void setQty(int qty);
}
