/**
 * 
 */
package com.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ara.idleheroes.controller.PlayerModifier;

/**
 * @author user
 *
 */
public class ClassTesting
{
	public static void main(String[] args)
	{
		PlayerModifier pm = new PlayerModifier();
		List playerItems = new ArrayList();
		List playerItemsQty = new ArrayList();
		
		playerItems.add("Potion");
		playerItemsQty.add(10);
		
		playerItems.add("Powerhouse Sword");
		playerItemsQty.add(2);
		
		pm.setPlayerItemName(playerItems);
		pm.setPlayerItemQty(playerItemsQty);
		
		showResources(pm);
		addItemToInventory(pm,"Potion",1);
		addItemToInventory(pm,"Powerhouse Sword",1);
		addItemToInventory(pm,"Devil Card",1);
		addItemToInventory(pm,"Potion",2);
		addItemToInventory(pm,"Elder Pillow",3);
		addItemToInventory(pm,"Powerhouse Sword",1);
		System.out.println("\n\n\n\n\n\n\n\n\n");
		showResources(pm);
	}
	
	public static void addItemToInventory(PlayerModifier pm, String addedItemName, int addedItemQty)
	{
		List listItemName = pm.getPlayerItemName();
		List listItemQty = pm.getPlayerItemQty();
		int counter = listItemName.size();
		boolean newlyAddedItem = false;
		
		if(listItemName!=null)
		{
			if(listItemQty.size()>0)
			{
				for(int i=0;i<counter;i++)
				{
					String currItemName = (String) listItemName.get(i);
					if(!addedItemName.equalsIgnoreCase(currItemName)) //item yang berbeda, flag it!
					{
						newlyAddedItem=true;
					}
					else //item yang sama, masukkan ke list yang lama, qty += newQty
					{
						int tempInt = (Integer) listItemQty.get(i);
						tempInt+=addedItemQty;
						listItemQty.set(i, tempInt);
						newlyAddedItem=false;
						break;
					}
				}
				
				//add new logic for newly added item below:
				if(newlyAddedItem)
				{
					listItemName.add(addedItemName);
					listItemQty.add(addedItemQty);
				}
			}
			else
			{
				listItemName.add(addedItemName);
				listItemQty.add(addedItemQty);
			}
		}
	}
	
	public static void showResources(PlayerModifier pm)
	{
		String choices = new String();
		
		System.out.println("=========================");
        System.out.println("Idle Heroes - Inventory");
        System.out.println("=========================");
        
        if(pm.getPlayerItemName()!=null)
        {
        	if(pm.getPlayerItemName().size()>0)
        	{
        		for(int i=0;i<pm.getPlayerItemName().size();i++)
        		{
        			System.out.println("["+(i+1)+"/10] "+pm.getPlayerItemName().get(i)+" ("+pm.getPlayerItemQty().get(i)+")");
        		}
        	}
        	else System.out.println("Kosong...");
        }
        else System.out.println("Kosong...");
	}
}
