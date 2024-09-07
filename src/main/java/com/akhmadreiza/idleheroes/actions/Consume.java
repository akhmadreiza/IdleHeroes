package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.constant.ItemType;
import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.items.consumable.Consumable;
import com.akhmadreiza.idleheroes.items.Item;

import java.util.HashMap;
import java.util.Scanner;

import static com.akhmadreiza.idleheroes.Utils.*;

public class Consume {

    private static Scanner scan = new Scanner(System.in);

    private PlayerModifier playerModifier;

    private HashMap<Integer, Consumable> selectionMap = new HashMap<>();

    public Consume(PlayerModifier playerModifier) {
        this.playerModifier = playerModifier;
    }

    public void begin() {
        printConsumables();
        String choices;
        Consumable selectedConsumableItem;
        println("[x] Keluar");
        do {
            print("Pilihan: ");
            choices = scan.nextLine();
            if (!choices.isEmpty() && !choices.isBlank() && !choices.equalsIgnoreCase("x")) {
                selectedConsumableItem = selectionMap.get(Integer.parseInt(choices));
                if (selectedConsumableItem != null) {
                    playerModifier.consumeItem(selectedConsumableItem);
                    playerModifier.subtractItemFromInventory(selectedConsumableItem);
                    healedNotification(selectedConsumableItem.getHealPoint());
                }
            } else {
                playerModifier.setNextState(StateEnum.BACK_TO_BASE);
                break;
            }
        } while (selectedConsumableItem == null);
    }

    private void healedNotification(int hpAddition) {
        clearScreen();

        println("=========================");
        println("Idle Heroes - HP Healed!");
        println("=========================");

        println("Berhasil heal " + hpAddition + " HP");
        println("HP saat ini: " + playerModifier.getPlayerHP() + " HP");

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();

        playerModifier.setNextState(StateEnum.BACK_TO_BASE);
    }

    private void printConsumables() {
        println("==============================");
        println("Idle Heroes - Inventory");
        println("==============================");

        playerModifier.printStat(false);

        println("Pilih item untuk heal:");

        HashMap<String, Item> inventoryMap = playerModifier.getInventory();

        int itemIdx = 1;
        for (Item eachItem : inventoryMap.values()) {
            if (eachItem.getItemType().equals(ItemType.CONSUMABLES)) {
                Consumable consumable = (Consumable) eachItem;
                println("[" + (itemIdx) + "] " + consumable.getName()
                        + " (" + consumable.getQty() + ")"
                        + " (Heal: " + consumable.getHealPoint() + " HP)"
                        + " - " + consumable.getItemType());
                selectionMap.put(itemIdx, consumable);
                itemIdx++;
            }
        }

        if (selectionMap.isEmpty()) {
            println("Item heal kosong...");
        }

        println("==============================");
    }
}
