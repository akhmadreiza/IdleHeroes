/**
 *
 */
package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.MonsterController;
import com.akhmadreiza.idleheroes.controller.MonsterModifier;
import com.akhmadreiza.idleheroes.controller.PlayerController;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.akhmadreiza.idleheroes.Utils.*;
import static com.akhmadreiza.idleheroes.constant.GeneralConstants.MONSTER_CODE_RABBIT;

/**
 * @author akhmadreiza
 */
public class Battle {

    static Scanner scan = new Scanner(System.in);
    private PlayerModifier playerModifier;

    public Battle(PlayerModifier playerModifier) {
        this.playerModifier = playerModifier;
    }

    public void begin() throws InterruptedException {
        playerModifier.setPrevState(StateEnum.BATTLE);
        int playerRealAtk;
        int monRealAtk;
        int totalHit = 0;

        MonsterController monsterController = new MonsterController();
        MonsterModifier monsterModifier = monsterController.getMonsterModifier(MONSTER_CODE_RABBIT); //TODO: TEMPORARILY HARDCODED MONSTER TO RABBIT

        int monsterHP = monsterModifier.getMonsterHP();
        int monsterMinAtk = monsterModifier.getMonsterMinAtk();
        int monsterMaxAtk = monsterModifier.getMonsterMaxAtk();

        //start battle
        clearScreen();
        println("Bertemu dengan musuh!");
        Thread.sleep(1200);

        String choices;

        do {
            clearScreen();
            println("Monster: " + monsterModifier.getMonsterName() + " | HP: " + monsterHP);
            println("HP Player: " + playerModifier.getPlayerHP());

            println("Tekan a untuk lawan");
            println("Tekan x untuk lari");
            print("Pilihan: ");
            choices = scan.nextLine();

            if (choices.equalsIgnoreCase("a")) {
                clearScreen();
                playerRealAtk = getRandBetweenInt(playerModifier.getPlayerMinAtk(), playerModifier.getPlayerMaxAtk());
                monRealAtk = getRandBetweenInt(monsterMinAtk, monsterMaxAtk);

                if (playerModifier.getPlayerName().equalsIgnoreCase("superibab")) {
                    playerRealAtk = 1000;
                    monRealAtk = 1;
                }

                if (playerModifier.getPlayerHP() > 0 && monsterHP > 0) {
                    println("Menyerang musuh! (ATK: " + playerRealAtk + ")");
                    monsterHP = monsterHP - playerRealAtk;
                    Thread.sleep(700);

                    println("Musuh menyerang! (ATK musuh: " + monRealAtk + ")");
                    playerModifier.setPlayerHP(playerModifier.getPlayerHP() - monRealAtk);
                }

                totalHit++;

                Thread.sleep(1000);
            } else if (choices.equals("x")) {
                clearScreen();
                println("Berhasil kabur dari musuh!");
            }

        } while (!choices.equalsIgnoreCase("x") && (monsterHP > 0 && playerModifier.getPlayerHP() > 0));

        if (monsterHP <= 0) {
            clearScreen();
            playerModifier.setPlayerExp(expObtainedFormula(totalHit, monsterModifier.getMonsterExp(), playerModifier.getPlayerExp()));

            PlayerController pc = new PlayerController();

            //get monster drop item list_start
            List monsterDrop = new ArrayList();
            List monsterDropQty = new ArrayList();
            monsterDrop = monsterModifier.getMonsterDropItem();
            monsterDropQty = monsterModifier.getMonsterDropQty();

            for (int i = 0; i < monsterDrop.size(); i++) {
                String itemName = new String();
                int itemQty;

                itemName = (String) monsterDrop.get(i);
                itemQty = (Integer) monsterDropQty.get(i);
                pc.addItemToInventory(playerModifier, itemName, itemQty);
            }
            //get monster drop item list_end

            if (playerModifier.getPlayerName().equalsIgnoreCase("superibab")) {
                playerModifier.setPlayerExp(100);
            }
            println("Musuh berhasil dilumpuhkan!");
        }

        if (playerModifier.getPlayerHP() <= 0) {
            clearScreen();
            println("Dikalahkan oleh musuh!");
        }

        do {
            println("Tekan tombol x untuk melanjutkan");
            print("Pilihan: ");
            choices = scan.nextLine();
        } while (!choices.equalsIgnoreCase("x"));

        updateNextState();
    }

    private void updateNextState() {
        if (playerModifier.getPlayerExp() >= 100) {
            playerModifier.setNextState(StateEnum.LEVEL_UP);
        } else {
            playerModifier.setNextState(StateEnum.BACK_TO_BASE);
        }
    }

    private int expObtainedFormula(int totalHit, int monExp, int currPlayerExp) {
        int playerExpAfterBattle;
        playerExpAfterBattle = totalHit * monExp / 2;
        println("exp didapatkan: " + playerExpAfterBattle);
        return currPlayerExp + playerExpAfterBattle;
    }
}
