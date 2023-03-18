package com.akhmadreiza.idleheroes;

import com.akhmadreiza.idleheroes.actions.Battle;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.entities.PlayerJobNovice;
import com.akhmadreiza.idleheroes.controller.PlayerController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProcess extends Utils {

    public static String playerName;
    public static String playerAge;

    public static int[] resources = {20, 20}; //wood,stones
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModifier pm = new PlayerModifier();
        String charclass;
        int num = 2;
        println("=========================");
        println("Idle Heroes v.0");
        println("=========================");

        print("Enter your Name: ");
        playerName = scan.nextLine();
        print("Enter your Age: ");
        playerAge = scan.nextLine();

        pm.setPlayerName(playerName);
        pm.setPlayerJob("Novice"); //init
        pm.setPlayerItemName(new ArrayList());
        pm.setPlayerItemQty(new ArrayList());

        if (PLAYER_NOVICE.equals(pm.getPlayerJob())) {
            PlayerJobNovice novice = new PlayerJobNovice();
            pm.setPlayerHP(novice.getHp());
            pm.setPlayerMaxAtk(novice.getMaxAtk());
            pm.setPlayerMinAtk(novice.getMinAtk());
            pm.setPlayerLevel(novice.getLevel());
        }

        welcomeMessage(pm);
    }

    public static void mainMenu() {
        try {
            clearScreen();

            println("=========================");
            println("Idle Heroes - Main Menu");
            println("=========================");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void welcomeMessage(PlayerModifier pm) throws InterruptedException {
        try {
            clearScreen();

            String choices = new String();

            println("==============================");
            println("Idle Heroes - Main Screen");
            println("==============================");

            println("Selamat datang " + pm.getPlayerName() + ", your HP: " + pm.getPlayerHP() + ", your Exp: " + pm.getPlayerExp() + ", your Level: " + pm.getPlayerLevel());

            println("Tekan 1: Melihat Resources saat ini");
            println("Tekan 2: Mencari Resource");
            println("Tekan 3: Crafting");
            println("Tekan 4: Restore HP");

            print("Pilihan: ");

            choices = scan.nextLine();
            if (choices.equals("1")) {
                showResources(pm);
            } else if (choices.equals("2")) {
                findResources(pm);
            } else if (choices.equals("4")) {
                int currHp = pm.getPlayerHP();
                pm.setPlayerHP(currHp + 50);
                welcomeMessage(pm);
            } else {
                welcomeMessage(pm);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void showResources(PlayerModifier pm) throws InterruptedException {
        try {
            clearScreen();

            String choices = new String();

            println("=========================");
            println("Idle Heroes - Inventory");
            println("=========================");

            if (pm.getPlayerItemName() != null) {
                if (pm.getPlayerItemName().size() > 0) {
                    for (int i = 0; i < pm.getPlayerItemName().size(); i++) {
                        println("[" + (i + 1) + "/10] " + pm.getPlayerItemName().get(i) + " (" + pm.getPlayerItemQty().get(i) + ")");
                    }
                } else println("Kosong...");
            } else println("Kosong...");

            do {
                println("Tekan tombol x untuk kembali ke main screen");
                print("Pilihan: ");
                choices = scan.nextLine();
            } while (!choices.equalsIgnoreCase("x"));

            welcomeMessage(pm);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void findResources(PlayerModifier pm) throws InterruptedException {
        try {
            clearScreen();

            String choices = new String();

            println("=============================");
            println("Idle Heroes - Finding Resources!");
            println("==============================");

            println("Wood: " + resources[0]);
            println("Stones: " + resources[1]);

            int foo = getRandPercentage();
            println("random foo: " + foo);

            println("\n\n\n");
            println("Finding.....");
            Thread.sleep(1500);

            if (foo < 60) //60% chance of meeting monster
            {
                startBattle(pm);
            } else {
                welcomeMessage(pm);
            }

            welcomeMessage(pm);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void startBattle(PlayerModifier pm) throws IOException, InterruptedException {
        Battle btl = new Battle();
        PlayerController pc = new PlayerController();

        btl.Battle(pm);
        if (pm.getPlayerExp() >= 100) {
            pc.levelUp(pm);
        }

        if (pm.getPlayerLevel() == 5) {
            promotePlayer(pm);
        }
    }

    public static void promotePlayer(PlayerModifier pm) throws InterruptedException {
        try {
            clearScreen();

            String choices = new String();
            PlayerController pc = new PlayerController();

            println("==============================");
            println("Idle Heroes - Job List");
            println("==============================");

            println("Selamat " + pm.getPlayerName() + " kamu berhak dipromosikan ke job 1.");
            println("Silakan pilih job yang kamu suka dibawah ini: ");

            println("Tekan 1: Warrior");
            println("Tekan 2: Archer");
            println("Tekan 3: Assasin");
            println("Tekan 4: Mage");

            print("Pilihan: ");

            choices = scan.nextLine();
            if (choices.equals("1")) {
                pm.setPlayerJob(PLAYER_WARRIOR);
                pc.promote(pm);
            } else {
                promotePlayer(pm);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
