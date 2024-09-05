/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

import static com.akhmadreiza.idleheroes.constant.PlayerConstants.MAX_HP_WARRIOR;

/**
 * @author akhmadreiza
 */
public class PlayerJobWarrior extends Player {

    @Override
    public int getHp() {
        return MAX_HP_WARRIOR;
    }

    @Override
    public int getMinAtk() {
        return 10;
    }

    @Override
    public int getMaxAtk() {
        return 20;
    }

    @Override
    public String getJob() {
        return "Warrior";
    }

    @Override
    public int getExp() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
