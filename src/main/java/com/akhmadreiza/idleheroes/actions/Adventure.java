package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;

import java.util.Scanner;

import static com.akhmadreiza.idleheroes.Utils.*;

public class Adventure {

    static Scanner scan = new Scanner(System.in);
    private PlayerModifier playerModifier;

    public Adventure(PlayerModifier playerModifier) {
        this.playerModifier = playerModifier;
    }

    public void begin() throws InterruptedException {
        playerModifier.setPrevState(StateEnum.ADVENTURE);
        clearScreen();

        println("=============================");
        println("Idle Heroes - Petualangan");
        println("==============================");

        println("Memulai petualangan.........");
        Thread.sleep(2000);
        println("Mencari musuh...............");
        Thread.sleep(2000);

        int foo = getRandPercentage();
        if (foo < 60) //60% chance of meeting monster
        {
            println("Musuh ditemukan!");
            Thread.sleep(1200);
            playerModifier.setNextState(StateEnum.BATTLE);
            new Battle(playerModifier).begin();
        } else {
            //TODO if do not meet monster, give the player random resource

            println("Musuh tidak ditemukan!");
            println("");
            print("Tekan enter untuk melanjutkan");
            scan.nextLine();

            playerModifier.setNextState(StateEnum.BACK_TO_BASE);
        }
    }
}
