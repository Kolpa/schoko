package de.kolpa.kpho;

import java.util.Scanner;

/**
 * Created by Kolpa on 11.04.2017 use at own risk might be horribly broken...
 */
public class Util {
    public static boolean inputBoolFromUser(String question, Scanner input) {
        System.out.print(question);
        String inp = input.next();

        while (!inp.equals("y") && !inp.equals("n")) {
            System.out.print(question);
            inp = input.next();
        }

        return inp.equals("y");
    }

    public static boolean inputRowFromUser(String question, Scanner input) {
        System.out.print(question);
        String inp = input.next();

        while (!inp.equals("R") && !inp.equals("S")) {
            System.out.print(question);
            inp = input.next();
        }

        return inp.equals("R");
    }
}
