/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

import static com.akhmadreiza.idleheroes.constant.PlayerConstants.MAX_HP_NOVICE;

/**
 * @author akhmadreiza
 */
public class PlayerJobNovice extends Player {

    @Override
    public int getHp() {
        return MAX_HP_NOVICE;
    }

    @Override
    public int getMinAtk() {
        return 8;
    }

    @Override
    public int getMaxAtk() {
        return 10;
    }

    @Override
    public String getJob() {
        return "Novice";
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
