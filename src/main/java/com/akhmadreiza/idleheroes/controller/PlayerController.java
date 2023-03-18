/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import com.akhmadreiza.idleheroes.entities.PlayerJobWarrior;

import java.util.List;

import static com.akhmadreiza.idleheroes.constant.GeneralConstants.PLAYER_WARRIOR;

/**
 * @author akhmadreiza
 */
public class PlayerController {

    public static void addItemToInventory(PlayerModifier pm, String addedItemName, int addedItemQty) {
        List listItemName = pm.getPlayerItemName();
        List listItemQty = pm.getPlayerItemQty();
        int counter = listItemName.size();
        boolean newlyAddedItem = false;

        if (listItemName != null) {
            if (listItemQty.size() > 0) {
                for (int i = 0; i < counter; i++) {
                    String currItemName = (String) listItemName.get(i);
                    if (!addedItemName.equalsIgnoreCase(currItemName)) //item yang berbeda, flag it!
                    {
                        newlyAddedItem = true;
                    } else //item yang sama, masukkan ke list yang lama, qty += newQty
                    {
                        int tempInt = (Integer) listItemQty.get(i);
                        tempInt += addedItemQty;
                        listItemQty.set(i, tempInt);
                        newlyAddedItem = false;
                        break;
                    }
                }

                //add new logic for newly added item below:
                if (newlyAddedItem) {
                    listItemName.add(addedItemName);
                    listItemQty.add(addedItemQty);
                }
            } else {
                listItemName.add(addedItemName);
                listItemQty.add(addedItemQty);
            }
        }
    }

    public String getPlayerJob() {
        String job = new String();
        return job;
    }

    public void levelUp(PlayerModifier pm) {
        int playerCurrLevel = pm.getPlayerLevel();
        int currPlayerExp = pm.getPlayerExp();
        int fwdExp = currPlayerExp - 100;

        pm.setPlayerExp(fwdExp);
        pm.setPlayerLevel(playerCurrLevel + 1);
    }

    public void promote(PlayerModifier pm) {
        if (pm.getPlayerJob().equalsIgnoreCase(PLAYER_WARRIOR)) {
            PlayerJobWarrior warrior = new PlayerJobWarrior();
            pm.setPlayerHP(warrior.getHp());
            pm.setPlayerMaxAtk(warrior.getMaxAtk());
            pm.setPlayerMinAtk(warrior.getMinAtk());
            pm.setPlayerLevel(warrior.getLevel());
        }
    }
	
	/*public void addItemToInventory(PlayerModifier pm, String addedItemName, int addedItemQty)
	{
		List listItemName = pm.getPlayerItemName();
		List listItemQty = pm.getPlayerItemQty();
		int counter = listItemName.size();
		
		if(listItemName!=null)
		{
			if(listItemQty.size()>0)
			{
				for(int i=0;i<counter;i++)
				{
					String currItemName = (String) listItemName.get(i);
					if(!addedItemName.equalsIgnoreCase(currItemName)) //item yang berbeda, maka masukkan ke list baru
					{
						listItemName.add(addedItemName);
						listItemQty.add(addedItemQty);
					}
					else //item yang sama, masukkan ke list yang lama, qty += newQty
					{
						int tempInt = (Integer) listItemQty.get(i);
						tempInt+=addedItemQty;
						listItemQty.set(i, tempInt);
					}
				}
			}
			else
			{
				listItemName.add(addedItemName);
				listItemQty.add(addedItemQty);
			}
		}
	}*/

    public void showItemsInInventory(PlayerModifier pm) {
        List playerItemsName = pm.getPlayerItemName();
        List playerItemsQty = pm.getPlayerItemQty();

        for (int i = 0; i < playerItemsName.size(); i++) {

        }
    }
}
