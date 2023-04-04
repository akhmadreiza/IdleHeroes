/**
 *
 */
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

/**
 * @author akhmadreiza
 */
public class MonsterRabbit extends Monster {

    @Override
    public String getName() {
        return "Rabbit";
    }

    @Override
    public String getClazz() {
        return "ANIMAL";
    }

    @Override
    public String getCode() {
        return "RBT";
    }

    @Override
    public int getHp() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public int getMinAtk() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public int getMaxAtk() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public int getStoredExp() {
        // TODO Auto-generated method stub
        return 10 * (getLevel() / 2);
    }

    @Override
    public int getLevel() {
        // TODO Auto-generated method stub
        return 8;
    }

    @Override
    public List<Item> getDrops() {
        List<Item> result = new ArrayList<>();

        //60% change got meat
        if (Utils.gotChance(60)) {
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
