/**
 *
 */
package com.akhmadreiza.idleheroes;

import java.io.IOException;
import java.util.Random;

/**
 * @author akhmadreiza
 */
public class Utils {
    public static void clearScreen() {
        if (getOsName().contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println("");
            }
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

    public static String getOsName() {
        return System.getProperty("os.name");
    }
}
