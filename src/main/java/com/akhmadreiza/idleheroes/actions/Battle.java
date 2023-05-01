/**
 *
 */
package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.MonsterModifier;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;

import java.util.Scanner;

import static com.akhmadreiza.idleheroes.Utils.*;

/**
 * @author akhmadreiza
 */
public class Battle {

    static Scanner scan = new Scanner(System.in);
    private PlayerModifier playerModifier;
    private MonsterModifier monsterModifier;

    public Battle(PlayerModifier playerModifier, MonsterModifier monsterModifier) {
        this.playerModifier = playerModifier;
        this.monsterModifier = monsterModifier;
    }

    public void begin() throws InterruptedException {
        playerModifier.setPrevState(StateEnum.BATTLE);
        int playerRealAtk;
        int monRealAtk;
        int totalHit = 0;
        int monsterHP = monsterModifier.getMonsterHP();

        //start battle
        String choices;

        clearScreen();
        println("Monster: " + monsterModifier.getMonsterName() + " | HP: " + monsterHP);
        println("HP Player: " + playerModifier.getPlayerHP());

        println("Tekan a untuk lawan");
        println("Tekan x untuk lari");
        print("Pilihan: ");
        choices = scan.nextLine();

        println("");
        do {
            if (choices.equalsIgnoreCase("a")) {
                //clearScreen();
                playerRealAtk = getRandBetweenInt(playerModifier.getPlayerMinAtk(), playerModifier.getPlayerMaxAtk());
                monRealAtk = getRandBetweenInt(monsterModifier.getMonsterMinAtk(), monsterModifier.getMonsterMaxAtk());

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
            //clearScreen();
            handleRewards(totalHit, monsterModifier);
        }

        if (playerModifier.getPlayerHP() <= 0) {
            //clearScreen();
            println("Dikalahkan oleh musuh!");
        }

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();

        updateNextState();
    }

    private void handleRewards(int totalHit, MonsterModifier monsterModifier) {
        println("");
        println("Musuh berhasil dilumpuhkan!");
        playerModifier.setPlayerExp(expObtainedFormula(totalHit, monsterModifier.getMonsterExp(), playerModifier.getPlayerExp()));
        playerModifier.addItemToInventory(monsterModifier.getMonsterDrops());
        print("mendapatkan ");
        monsterModifier.printMonsterDrops();
        println("");
        if (playerModifier.getPlayerName().equalsIgnoreCase("superibab")) {
            playerModifier.setPlayerExp(100);
        }
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
        println("mendapatkan " + playerExpAfterBattle + " exp");
        return currPlayerExp + playerExpAfterBattle;
    }
}
