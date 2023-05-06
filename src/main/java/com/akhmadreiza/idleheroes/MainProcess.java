package com.akhmadreiza.idleheroes;

import com.akhmadreiza.idleheroes.actions.Adventure;
import com.akhmadreiza.idleheroes.actions.Consume;
import com.akhmadreiza.idleheroes.constant.StateEnum;
import com.akhmadreiza.idleheroes.controller.PlayerModifier;
import com.akhmadreiza.idleheroes.entities.PlayerJobNovice;
import com.akhmadreiza.idleheroes.entities.PlayerJobWarrior;
import com.akhmadreiza.idleheroes.exception.FeatureUnimplementedException;

import java.io.IOException;
import java.util.Scanner;

import static com.akhmadreiza.idleheroes.Utils.*;

public class MainProcess {

    public static String playerName;

    public static int[] resources = {20, 20}; //wood,stones
    private static Scanner scan = new Scanner(System.in);

    private static PlayerModifier playerModifier;

    public static void main(String[] args) throws IOException, InterruptedException {
        clearScreen();
        println("=========================");
        println("Idle Heroes V.0");
        println("OS: " + getOsName());
        println("=========================");

        print("Masukkan username: ");
        playerName = scan.nextLine();
        initNewGame();
        welcomeMessage();
    }

    private static void initNewGame() {
        playerModifier = new PlayerModifier(new PlayerJobNovice());
        playerModifier.setPlayerName(playerName);
        playerModifier.setPrevState(StateEnum.INIT);
    }

    private static void welcomeMessage() throws InterruptedException {
        clearScreen();

        String choices = new String();

        println("==============================");
        println("Idle Heroes - Home Base");
        println("==============================");
        println("Name  : " + playerModifier.getPlayerName());
        println("Job   : " + playerModifier.getPlayerJob());
        println("Level : " + playerModifier.getPlayerLevel());
        println("XP    : " + playerModifier.getPlayerExp() + "/100");
        println("HP    : " + playerModifier.getPlayerHP() + "/" + playerModifier.getPlayerMaxHp());
        println("==============================");

        println("");
        println("[1] Lihat stat   | [4] Crafting");
        println("[2] Lihat tas    | [5] Heal");
        println("[3] Berpetualang | ");
        println("[x] Keluar");
        println("");

        print("Pilihan: ");

        choices = scan.nextLine();
        if (choices.equals("1")) {
            printPlayerStats();
        } else if (choices.equals("2")) {
            showResources();
        } else if (choices.equals("3")) {
            playerModifier.setNextState(StateEnum.ADVENTURE);
            new Adventure(playerModifier).begin();
        } else if (choices.equals("4")) {
            featureNotAvailableNotification();
            playerModifier.setNextState(StateEnum.INIT);
        } else if (choices.equals("5")) {
            clearScreen();
            new Consume(playerModifier).begin();
        } else if (choices.equalsIgnoreCase("x")) {
            exitNotification();
            System.exit(0);
        } else {
            navigateTo(StateEnum.BACK_TO_BASE);
        }
        navigateTo(playerModifier.getNextState());
    }

    private static void navigateTo(StateEnum nextState) throws InterruptedException {
        if (nextState.name().equalsIgnoreCase(StateEnum.BACK_TO_BASE.name())
                || nextState.name().equalsIgnoreCase(StateEnum.INIT.name())) {
            welcomeMessage();
        } else if (nextState.name().equalsIgnoreCase(StateEnum.LEVEL_UP.name())) {
            playerModifier.levelUp();
            levelUpNotification();
            if (playerModifier.getPlayerLevel() == 5) {
                playerModifier.setNextState(StateEnum.PROMOTE);
            }
            navigateTo(playerModifier.getNextState());
        } else if (nextState.name().equalsIgnoreCase(StateEnum.PROMOTE.name())) {
            promotePlayer();
            navigateTo(playerModifier.getNextState());
        }
    }

    private static void printPlayerStats() {
        clearScreen();
        playerModifier.printStat();

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();

        playerModifier.setNextState(StateEnum.BACK_TO_BASE);
    }

    private static void exitNotification() {
        clearScreen();
        println("=========================");
        println("Idle Heroes - Exit Game");
        println("=========================");

        println("Terima kasih telah bermain..");
    }

    private static void levelUpNotification() {
        clearScreen();

        println("=========================");
        println("Idle Heroes - LEVEL UP!");
        println("=========================");

        println("Selamat kamu naik ke level " + playerModifier.getPlayerLevel() + "!!");

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();

        playerModifier.setNextState(StateEnum.BACK_TO_BASE);
    }

    private static void showResources() {
        clearScreen();
        playerModifier.printAllItems();

        String choices;
        do {
            println("Tekan tombol x untuk melanjutkan");
            print("Pilihan: ");
            choices = scan.nextLine();
        } while (!choices.equalsIgnoreCase("x"));

        playerModifier.setNextState(StateEnum.BACK_TO_BASE);
    }

    private static void featureNotAvailableNotification() {
        clearScreen();
        println("=========================");
        println("Idle Heroes - Mohon Maaf");
        println("=========================");

        println("Fitur ini saat ini sedang dalam pengembangan.");
        println("Email: reizaarmando@gmail.com");

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();
    }

    private static void promotePlayer() {
        clearScreen();

        String choices = new String();

        println("==============================");
        println("Idle Heroes - Job List");
        println("==============================");

        println("Selamat " + playerModifier.getPlayerName() + " kamu berhak dipromosikan ke job 1.");
        println("Silakan pilih job yang kamu suka dibawah ini: ");

        println("Tekan 1: Warrior");
        println("Tekan 2: Archer");
        println("Tekan 3: Assasin");
        println("Tekan 4: Mage");

        print("Pilihan: ");

        choices = scan.nextLine();
        try {
            if (choices.equals("1")) {
                playerModifier.promote(new PlayerJobWarrior());
                promoteSuccessNotification();
                playerModifier.setNextState(StateEnum.BACK_TO_BASE);
            } else {
                featureNotAvailableNotification();
                promotePlayer();
            }
        } catch (FeatureUnimplementedException featureUnimplementedException) {
            featureUnimplementedException.printStackTrace();
            promotePlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void promoteSuccessNotification() {
        clearScreen();
        println("==============================");
        println("Idle Heroes - Success Promoted");
        println("==============================");

        println("Selamat " + playerModifier.getPlayerName() + " kamu berhasil promote ke job " + playerModifier.getPlayerJob() + "!");

        println("");
        print("Tekan enter untuk melanjutkan");
        scan.nextLine();
    }
}
