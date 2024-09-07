/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

import com.akhmadreiza.idleheroes.items.Item;
import com.akhmadreiza.idleheroes.items.consumable.Meat;
import com.akhmadreiza.idleheroes.items.craft.AnimalSkin;
import com.akhmadreiza.idleheroes.items.craft.Bottle;
import com.akhmadreiza.idleheroes.items.craft.RedHerbs;

import java.util.ArrayList;
import java.util.List;

import static com.akhmadreiza.idleheroes.Utils.getRandBetweenInt;

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

        int chance = getRandBetweenInt(1, 100);

        //drop rate
        if (chance <= 5) {
            result.add(new Meat(1));
        }

        if (chance <= 95) {
            result.add(new AnimalSkin(1));
            result.add(new RedHerbs(2));
        }

        if (chance <= 80) {
            result.add(new Bottle(1));
        }

        return result;
    }

    @Override
    public String getAvatar() {
        return " \\\\\n" +
                "  \\\\_\n" +
                "  ( _\\\n" +
                "  / \\__\n" +
                " / _/`\"`\n" +
                "{\\  )_\n" +
                "  `\"\"\"`";
    }
}
