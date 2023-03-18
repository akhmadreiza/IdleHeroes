/**
 *
 */
package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.MainProcess;
import com.akhmadreiza.idleheroes.Utils;
import com.akhmadreiza.idleheroes.controller.MonsterController;
import com.akhmadreiza.idleheroes.controller.MonsterModifier;
import com.akhmadreiza.idleheroes.controller.PlayerController;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;

import java.io.IOException;
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
    public int _gPlayersHp;
    public int _gPlayersMinAtk;
    public int _gPlayersMaxAtk;
    Utils gameUtil = new Utils();
    MainProcess mainProc = new MainProcess();
    //PlayerModifier pm = new PlayerModifier();

    public PlayerModifier Battle(PlayerModifier pm) throws IOException, InterruptedException {
        this._gPlayersMinAtk = pm.getPlayerMinAtk();
        this._gPlayersMaxAtk = pm.getPlayerMaxAtk();
        this._gPlayersHp = pm.getPlayerHP();

        int playerRealAtk;
        int monRealAtk;
        int totalHit = 0;

        MonsterController monController = new MonsterController();
        MonsterModifier monsMod = (MonsterModifier) monController.getMonsterModifier(MONSTER_CODE_RABBIT); //TODO: TEMPORARILY HARDCODED MONSTER TO RABBIT

        int _monHp = monsMod.getMonsterHP();
        int _monMinAtk = monsMod.getMonsterMinAtk();
        int _monMaxAtk = monsMod.getMonsterMaxAtk();

        //start battle
        clearScreen();
        println("Bertemu dengan musuh!");
        Thread.sleep(1200);

        String choices = new String();

        do {
            clearScreen();
            println("Monster: " + monsMod.getMonsterName() + " | HP: " + _monHp);
            println("HP Player: " + pm.getPlayerHP());

            println("Tekan a untuk lawan");
            println("Tekan x untuk lari");
            print("Pilihan: ");
            choices = scan.nextLine();

            if (choices.equalsIgnoreCase("a")) {
                clearScreen();
                playerRealAtk = getRandBetweenInt(_gPlayersMinAtk, _gPlayersMaxAtk);
                monRealAtk = getRandBetweenInt(_monMinAtk, _monMaxAtk);

                if (pm.getPlayerName().equalsIgnoreCase("superibab")) {
                    playerRealAtk = 1000;
                    monRealAtk = 1;
                }

                if (pm.getPlayerHP() > 0 && _monHp > 0) {
                    println("Menyerang musuh! (ATK: " + playerRealAtk + ")");
                    _monHp = _monHp - playerRealAtk;
                    Thread.sleep(700);

                    println("Musuh menyerang! (ATK musuh: " + monRealAtk + ")");
                    pm.setPlayerHP(pm.getPlayerHP() - monRealAtk);
                }

                totalHit++;

                Thread.sleep(1000);
            } else if (choices.equals("x")) {
                return pm;
            }

        } while (!choices.equalsIgnoreCase("x") && (_monHp > 0 && pm.getPlayerHP() > 0));

        if (_monHp <= 0) {
            clearScreen();
            //expObtainedFormula(totalHit, monsMod.getMonsterExp(), pm.getPlayerExp());
            pm.setPlayerExp(expObtainedFormula(totalHit, monsMod.getMonsterExp(), pm.getPlayerExp()));

            PlayerController pc = new PlayerController();

            //get monster drop item list_start
            List monsterDrop = new ArrayList();
            List monsterDropQty = new ArrayList();
            monsterDrop = monsMod.getMonsterDropItem();
            monsterDropQty = monsMod.getMonsterDropQty();

            for (int i = 0; i < monsterDrop.size(); i++) {
                String itemName = new String();
                int itemQty;

                itemName = (String) monsterDrop.get(i);
                itemQty = (Integer) monsterDropQty.get(i);
                pc.addItemToInventory(pm, itemName, itemQty);
            }
            //get monster drop item list_end


            //pc.addItemToInventory(pm,"A",itemQtyToBeAdded,monsMod.getMonsterDropItem(),pm.getPlayerItemName()); //THIS LINE USED FOR MOVE DROPPED ITEM TO INVENTORY
    		/*pc.addItemToInventory(pm,"Potion",10);
    		pc.addItemToInventory(pm,"Powerhouse Sword",1);*/

            if (pm.getPlayerName().equalsIgnoreCase("superibab")) {
                pm.setPlayerExp(100);
            }
            println("Musuh berhasil dilumpuhkan!");
        }

        if (pm.getPlayerHP() <= 0) {
            clearScreen();
            println("Dikalahkan oleh musuh!");
        }

        do {
            println("Tekan tombol x untuk kembali ke main screen");
            print("Pilihan: ");
            choices = scan.nextLine();
        } while (!choices.equalsIgnoreCase("x"));

        return pm;
    }

    public int expObtainedFormula(int totalHit, int monExp, int currPlayerExp) {
        int playerExpAfterBattle;
        playerExpAfterBattle = (int) (totalHit * monExp / 2);
        println("exp didapatkan: " + playerExpAfterBattle);
        return currPlayerExp + playerExpAfterBattle;
    }
}
