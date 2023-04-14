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
        // TODO Auto-generated method stub
        return MAX_HP_WARRIOR;
    }

    @Override
    public int getMinAtk() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public int getMaxAtk() {
        // TODO Auto-generated method stub
        return 20;
    }

    @Override
    public String getJob() {
        // TODO Auto-generated method stub
        return "Warrior";
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

//	public ArrayList<E>
}
