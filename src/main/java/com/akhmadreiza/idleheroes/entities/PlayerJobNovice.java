/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

/**
 * @author akhmadreiza
 *
 */
public class PlayerJobNovice extends Player {

    @Override
    public int getHp() {
        // TODO Auto-generated method stub
        return 50;
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
