/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

import com.akhmadreiza.idleheroes.Utils;
import com.akhmadreiza.idleheroes.items.Item;
import com.akhmadreiza.idleheroes.items.consumable.Meat;
import com.akhmadreiza.idleheroes.items.craft.AnimalSkin;

import java.util.ArrayList;
import java.util.List;

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
        return 30;
    }

    @Override
    public int getMinAtk() {
        return 1;
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
        return 8;
    }

    @Override
    public List<Item> getDrops() {
        List<Item> result = new ArrayList<>();

        //meat drop rate
        if (Utils.gotChance(75)) {
            result.add(new Meat(1));
        }

        //animal skin drop rate
        if (Utils.gotChance(90)) {
            result.add(new AnimalSkin(1));
        }

        return result;
    }
}
