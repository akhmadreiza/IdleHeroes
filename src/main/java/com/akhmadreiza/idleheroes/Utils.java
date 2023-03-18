/**
 *
 */
package com.akhmadreiza.idleheroes;

import java.io.IOException;
import java.util.Random;

/**
 * @author akhmadreiza
 *
 */
public class Utils {

    public static String MONSTER_CODE_RABBIT = "RBT";
    public static String ITEM_RABBIT_SKIN = "rbt_skin";
    public static String ITEM_RABBIT_MEAT = "rbt_meat";
    public static String ITEM_CARROT = "carrot";

    public static String ITEM_WOOD = "wood";
    public static String ITEM_STONE = "stone";

    public static String PLAYER_NOVICE = "Novice";
    public static String PLAYER_WARRIOR = "Warrior";

    public static void clearScreen() throws IOException {
        for (int i = 1; i <= 100; i++) {
            println("\n");
        }
    }

    public static void print(String print) {
        System.out.print(print);
    }

    public static void println(String print) {
        System.out.println(print);
    }

    public static int getRandPercentage() {
        return (int) (Math.random() * 100);
    }

    public static int getRandBetweenInt(int minVal, int maxVal) {
        Random ran = new Random();
        return ran.nextInt((maxVal - minVal) + 1) + minVal;
    }
}
