package com.akhmadreiza.idleheroes.actions;

import com.akhmadreiza.idleheroes.biomes.Biome;
import com.akhmadreiza.idleheroes.biomes.BiomeFactory;
import com.akhmadreiza.idleheroes.biomes.Biomes;
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

        String choices;

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

        switch (choices) {
            case "1":
                beginAdv(BiomeFactory.generateBiome(Biomes.PLAYGROUND));
                break;
            case "2":
                beginAdv(BiomeFactory.generateBiome(Biomes.FOREST));
                break;
            case "x":
                playerModifier.setNextState(StateEnum.BACK_TO_BASE);
                break;
            default:
                beginAdv(BiomeFactory.generateBiome(Biomes.PLAYGROUND));
                break;
        }
    }

    private void beginAdv(Biome biome) throws InterruptedException {
        clearScreen();
        println("==============================");
        println("Idle Heroes - " + biome.getBiomeName());
        println("==============================");
        println("Memulai petualangan.........");
        Thread.sleep(1000);
        println("Mencari musuh...............");
        Thread.sleep(1000);

        int foo = getRandPercentage();
        if (foo < 90) //80% chance of meeting monster
        {
            println("Musuh ditemukan!");
            Thread.sleep(1000);
            playerModifier.setNextState(StateEnum.BATTLE);
            new Battle(playerModifier, biome).begin();
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
