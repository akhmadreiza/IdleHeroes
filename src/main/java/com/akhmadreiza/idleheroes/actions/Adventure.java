package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.biomes.Playground;
import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.MonsterModifier;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.entities.Monster;
import com.akhmadreiza.idleheroes.entities.MonsterRabbit;

import java.util.Scanner;

import static com.akhmadreiza.idleheroes.Utils.*;

public class Adventure {

    static Scanner scan = new Scanner(System.in);

    private PlayerModifier playerModifier;

    private static final Monster DEFAULT_MONSTER = new MonsterRabbit();

    public Adventure(PlayerModifier playerModifier) {
        this.playerModifier = playerModifier;
    }

    public void begin() throws InterruptedException {
        playerModifier.setPrevState(StateEnum.ADVENTURE);
        clearScreen();

        String choices = new String();

        println("=============================");
        println("Idle Heroes - Petualangan");
        println("==============================");

        println("Pilih area:");
        println("[1] Playground");
        println("[2] Forest");
        println("[x] Keluar");
        println("");

        print("Pilihan: ");

        choices = scan.nextLine();

        if (choices.equals("1")) {
            Playground playground = new Playground();
            beginAdv(playground.getMonster());
        } else if (choices.equals("x")) {
            playerModifier.setNextState(StateEnum.BACK_TO_BASE);
        } else {
            beginAdv(DEFAULT_MONSTER);
        }
    }

    private void beginAdv(Monster monster) throws InterruptedException {
        println("Memulai petualangan.........");
        Thread.sleep(1000);
        println("Mencari musuh...............");
        Thread.sleep(1000);

        int foo = getRandPercentage();
        if (foo < 80) //80% chance of meeting monster
        {
            println("Musuh ditemukan!");
            Thread.sleep(1000);
            playerModifier.setNextState(StateEnum.BATTLE);
            MonsterModifier monsterModifier = new MonsterModifier(monster);
            new Battle(playerModifier, monsterModifier).begin();
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
