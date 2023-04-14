/**
 *
 */
package com.akhmadreiza.idleheroes.controller;

import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.constant.PlayerConstants;
import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.entities.Player;
import com.akhmadreiza.idleheroes.entities.PlayerJobNovice;
import com.akhmadreiza.idleheroes.entities.PlayerJobWarrior;
import com.akhmadreiza.idleheroes.exception.FeatureUnimplementedException;
import com.akhmadreiza.idleheroes.items.Consumable;
import com.akhmadreiza.idleheroes.items.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

import static com.akhmadreiza.idleheroes.Utils.println;
import static com.akhmadreiza.idleheroes.constant.GeneralConstants.PLAYER_NOVICE;
import static com.akhmadreiza.idleheroes.constant.GeneralConstants.PLAYER_WARRIOR;

/**
 * @author akhmadreiza
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModifier {

    private int playerHP;
    private int playerMinAtk;
    private int playerMaxAtk;
    private String playerJob;
    private String playerName;
    private int playerExp;
    private int playerLevel;
    private StateEnum prevState;
    private StateEnum nextState;
    private HashMap<String, Item> inventory;

    public PlayerModifier(Player player) {
        if (player instanceof PlayerJobNovice) {
            PlayerJobNovice novice = new PlayerJobNovice();
            this.playerJob = novice.getJob();
            this.playerHP = novice.getHp();
            this.playerMaxAtk = novice.getMaxAtk();
            this.playerMinAtk = novice.getMinAtk();
            this.playerLevel = novice.getLevel();
            this.inventory = new HashMap<>();
        }
    }

    public void addItemToInventory(Item item) {
        //if item already exists in map, just increment the qty
        if (inventory.containsKey(item.getName())) {
            Item itemInMap = inventory.get(item.getName());
            itemInMap.setQty(itemInMap.getQty() + item.getQty());
            inventory.put(itemInMap.getName(), itemInMap);
        } else {
            //otherwise, put item name to hashmap
            inventory.put(item.getName(), item);
        }
    }

    public void subtractItemFromInventory(Item item) {
        Item itemInMap = inventory.get(item.getName());
        itemInMap.setQty(itemInMap.getQty() - 1);
        if (itemInMap.getQty() == 0) {
            inventory.remove(itemInMap.getName());
        } else {
            inventory.put(itemInMap.getName(), itemInMap);
        }
    }

    public void addItemToInventory(List<Item> items) {
        if (!items.isEmpty()) {
            items.forEach(this::addItemToInventory);
        }
    }

    public void consumeItem(Consumable selectedConsumableItem) {
        int maxHp = getPlayerMaxHp();
        int currHp = this.playerHP;
        int hpAddition = selectedConsumableItem.getHealPoint();
        int hpAfterHeal = currHp + hpAddition;
        this.playerHP = Math.min(hpAfterHeal, maxHp);
    }

    public void levelUp() {
        playerLevel = playerLevel + 1;
        playerExp = 0;
    }

    public void promote(Player player) {
        if (player instanceof PlayerJobWarrior) {
            PlayerJobWarrior warrior = new PlayerJobWarrior();
            this.playerJob = warrior.getJob();
            this.playerHP = warrior.getHp();
            this.playerMaxAtk = warrior.getMaxAtk();
            this.playerMinAtk = warrior.getMinAtk();
            this.playerLevel = warrior.getLevel();
            this.playerExp = warrior.getExp();
        } else {
            throw new FeatureUnimplementedException("Player Job not implemented yet");
        }
    }

    public void printStat() {
        println("==============================");
        println("Idle Heroes - Your Stats");
        println("==============================");
        println("HP    : " + this.playerHP);
        println("Job   : " + this.playerJob);
        println("Level : " + this.playerLevel);
        println("XP    : " + this.playerLevel);
        println("==============================");
    }

    public void printInventory(ItemType itemType) {
        println("==============================");
        println("Idle Heroes - Inventory");
        println("==============================");

        if (inventory.values().isEmpty()) {
            println("Kosong...");
        }

        int itemIdx = 1;
        for (Item eachItem : inventory.values()) {
            if (itemType != null) {
                if (eachItem.getItemType().equals(itemType)) {
                    println("[" + (itemIdx) + "] " + eachItem.getName() + " (" + eachItem.getQty() + ")" + " - type: " + eachItem.getItemType());
                    itemIdx++;
                }
            } else {
                println("[" + (itemIdx) + "] " + eachItem.getName() + " (" + eachItem.getQty() + ")");
                itemIdx++;
            }
        }
        println("==============================");
    }

    public void  printAllItems() {
        printInventory(null);
    }

    public int getPlayerMaxHp() {
        if (this.playerJob.equalsIgnoreCase(PLAYER_NOVICE)) {
            return PlayerConstants.MAX_HP_NOVICE;
        } else if (this.playerJob.equalsIgnoreCase(PLAYER_WARRIOR)) {
            return PlayerConstants.MAX_HP_WARRIOR;
        }
        return 0;
    }
}
