package com.akhmadreiza.idleheroes.items;

import com.akhmadreiza.idleheroes.constant.ItemType;
import lombok.Data;

@Data
public class Item {
    private String name;
    private int qty;
    private ItemType itemType;
}
