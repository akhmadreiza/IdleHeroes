/**
 *
 */
package com.akhmadreiza.idleheroes.entities;

import com.akhmadreiza.idleheroes.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akhmadreiza
 *
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
    public List dropItemQty() {
        int[] itemQtyArr = {1, 1, 1};
        int itemQty;
        List itemQtyLst = new ArrayList();

        for (int i = 0; i < itemQtyArr.length; i++) {
            itemQtyLst.add(itemQtyArr[i]);
        }

        return itemQtyLst;
    }

    @Override
    public List dropItemName() {
        String[] itemQtyArr = {Utils.ITEM_RABBIT_SKIN, Utils.ITEM_RABBIT_MEAT, Utils.ITEM_CARROT};
        String itemQty;
        List itemLst = new ArrayList();

        for (int i = 0; i < itemQtyArr.length; i++) {
            itemLst.add(itemQtyArr[i]);
        }

        return itemLst;
    }
}
