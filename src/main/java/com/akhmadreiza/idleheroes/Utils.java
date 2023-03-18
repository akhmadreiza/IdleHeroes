/**
 *
 */
package com.akhmadreiza.idleheroes;

import java.util.Random;

/**
 * @author akhmadreiza
 */
public class Utils {
    public static void clearScreen() {
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
