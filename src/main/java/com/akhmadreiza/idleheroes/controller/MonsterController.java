/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import com.akhmadreiza.idleheroes.Utils;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;

/**
 * @author akhmadreiza
 *
 */
public class MonsterController extends Utils {

    public MonsterModifier getMonsterModifier(String monsterCode) {
        MonsterModifier mons = new MonsterModifier();

        if (MONSTER_CODE_RABBIT.equalsIgnoreCase(monsterCode)) {
            MonsterRabbit rbt = new MonsterRabbit();

            mons.setMonsterName(rbt.getName());
            mons.setMonsterClass(rbt.getClazz());
            mons.setMonsterHP(rbt.getHp());
            mons.setMonsterMaxAtk(rbt.getMaxAtk());
            mons.setMonsterMinAtk(rbt.getMinAtk());
            mons.setMonsterExp(rbt.getStoredExp());
            mons.setMonsterLevel(rbt.getLevel());
            mons.setMonsterDropItem(rbt.dropItemName());
            mons.setMonsterDropQty(rbt.dropItemQty());
        }
        return mons;
    }
}
