package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.items.Craftable;
import com.akhmadreiza.idleheroes.items.consumable.Consumable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;

import static com.akhmadreiza.idleheroes.Utils.*;

public class Craft {
    private static Scanner scan = new Scanner(System.in);

    private HashMap<Integer, Craftable> selectionMap = new HashMap<>();

    public void begin(PlayerModifier playerModifier) {
        printCraftableItemList(playerModifier);
        String choices;
        Craftable selectedConsumableItem;
        println("[x] Keluar");

        do {
            print("Pilihan: ");
            choices = scan.nextLine();
            if (!choices.isEmpty() && !choices.isBlank() && !choices.equalsIgnoreCase("x")) {
                selectedConsumableItem = selectionMap.get(Integer.parseInt(choices));

                craftSuccessNotif(playerModifier, selectedConsumableItem);

                Consumable consumable = (Consumable) selectedConsumableItem;
                consumable.setQty(1);

                //add item to player inventory
                playerModifier.addItemToInventory(consumable);

                //remove raw material from player inventory
                Map<String, Integer> recipeMap = selectedConsumableItem.getRecipe();
                for (String itemName : recipeMap.keySet()) {
                    for (int i = 0; i < recipeMap.get(itemName); i++) {
                        playerModifier.subtractItemFromInventory(itemName);
                    }
                }

            } else {
                playerModifier.setNextState(StateEnum.BACK_TO_BASE);
                break;
            }

        } while (selectedConsumableItem == null);
    }

    private void craftSuccessNotif(PlayerModifier playerModifier, Craftable selected) {
        clearScreen();

        println("=========================");
        println("Idle Heroes - Berhasil crafting!");
        println("=========================");

        println("Berhasil crafting " + selected.getClass().getSimpleName());

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();

        playerModifier.setNextState(StateEnum.BACK_TO_BASE);
    }

    private void printCraftableItemList(PlayerModifier playerModifier) {
        //list down craftable items and its craftable flag
        clearScreen();

        println("==============================");
        println("Idle Heroes - Crafting");
        println("==============================");

        int idx = 1;
        ServiceLoader<Craftable> craftableServiceLoader = ServiceLoader.load(Craftable.class);
        for (Craftable impl : craftableServiceLoader) {
            if (impl.ableToCraft(playerModifier)) {
                Map<String, Integer> recipeMap = impl.getRecipe();
                StringBuilder strRecipe = new StringBuilder();
                for (String item : recipeMap.keySet()) {
                    strRecipe.append(item).append(" (").append(recipeMap.get(item)).append("), ");
                }
                println("[" + idx + "] " + impl.getClass().getSimpleName() + " - " + strRecipe.delete(strRecipe.length() - 2, strRecipe.length()) + " - Craftable: " + impl.ableToCraft(playerModifier));
                selectionMap.put(idx, impl);
            }
            idx++;
        }

        if (selectionMap.isEmpty()) {
            println("Blueprint kosong...");
        }

        println("==============================");
    }
}
