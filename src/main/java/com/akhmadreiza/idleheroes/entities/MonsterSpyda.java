package com.akhmadreiza.idleheroes.entities;

import com.akhmadreiza.idleheroes.Utils;
import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.items.Consumable;
import com.akhmadreiza.idleheroes.items.Item;

import java.util.ArrayList;
import java.util.List;

import static com.akhmadreiza.idleheroes.constant.GeneralConstants.ANIMAL_SKIN;
import static com.akhmadreiza.idleheroes.constant.GeneralConstants.MEAT;
import static com.akhmadreiza.idleheroes.constant.ItemType.RESOURCES;

public class MonsterSpyda extends Monster {
    @Override
    public String getName() {
        return "Spyda";
    }

    @Override
    public String getClazz() {
        return "ANIMAL";
    }

    @Override
    public String getCode() {
        return "SPD";
    }

    @Override
    public int getHp() {
        return 40;
    }

    @Override
    public int getMinAtk() {
        return 2;
    }

    @Override
    public int getMaxAtk() {
        return 3;
    }

    @Override
    public int getStoredExp() {
        return 10 * (getLevel() / 2);
    }

    @Override
    public int getLevel() {
        return 10;
    }

    @Override
    public List<Item> getDrops() {
        List<Item> result = new ArrayList<>();

        //10% change got meat
        if (Utils.gotChance(10)) {
            Consumable meat = new Consumable();
            meat.setName(MEAT);
            meat.setQty(1);
            meat.setHealPoint(10);
            meat.setItemType(ItemType.CONSUMABLES);
            result.add(meat);
        }

        //90% chance got animal skin
        if (Utils.gotChance(90)) {
            Item skin = new Item();
            skin.setName(ANIMAL_SKIN);
            skin.setItemType(RESOURCES);
            skin.setQty(1);
            result.add(skin);
        }

        return result;
    }
}
