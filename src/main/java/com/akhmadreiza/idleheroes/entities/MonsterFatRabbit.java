package com.akhmadreiza.idleheroes.entities;

import com.akhmadreiza.idleheroes.items.Item;
import com.akhmadreiza.idleheroes.items.consumable.Meat;
import com.akhmadreiza.idleheroes.items.craft.AnimalSkin;

import java.util.ArrayList;
import java.util.List;

import static com.akhmadreiza.idleheroes.Utils.getRandBetweenInt;

public class MonsterFatRabbit extends MonsterRabbit {
    @Override
    public String getName() {
        return "Fat Rabbit";
    }

    @Override
    public String getCode() {
        return "FRBT";
    }

    @Override
    public int getHp() {
        return super.getHp()*2;
    }

    @Override
    public List<Item> getDrops() {
        List<Item> result = new ArrayList<>();

        int chance = getRandBetweenInt(1, 100);

        //meat drop rate
        if (chance <= 95) {
            result.add(new Meat(2));
        }

        //animal skin drop rate
        if (chance <= 35) {
            result.add(new AnimalSkin(1));
        }

        return result;
    }

    @Override
    public String getAvatar() {
        return "           ((`\\\n" +
                "        ___ \\\\ '--._\n" +
                "     .'`   `'    o  )\n" +
                "    /    \\   '. __.'\n" +
                "   _|    /_  \\ \\_\\_\n" +
                "  {_\\______\\-'\\__\\_\\";
    }
}
