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
        // TODO Auto-generated method stub
        return MAX_HP_NOVICE;
    }

    @Override
    public int getMinAtk() {
        // TODO Auto-generated method stub
        return 8;
    }

    @Override
    public int getMaxAtk() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public String getJob() {
        // TODO Auto-generated method stub
        return "Novice";
    }

    @Override
    public int getExp() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getLevel() {
        // TODO Auto-generated method stub
        return 1;
    }

}
