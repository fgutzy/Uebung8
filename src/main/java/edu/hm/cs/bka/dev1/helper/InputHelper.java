package edu.hm.cs.bka.dev1.helper;

import java.util.Scanner;

public class InputHelper {

    private static Scanner in = new Scanner(System.in);

    public static int askForInteger(String prompt) {
        Integer result = null;
        do {
            System.out.print(prompt + " > ");
            String input = in.nextLine();
            try {
                result = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ungueltige Eingabe!");
            }
        } while (result == null);
        return result;
    }

    public static float askForFloat(String prompt) {
        Float result = null;
        do {
            System.out.print(prompt + " > ");
            String input = in.nextLine();
            try {
                result = Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Ungueltige Eingabe!");
            }
        } while (result == null);
        return result;
    }

    public static String askForString(String prompt) {
        String result = null;
        do {
            System.out.print(prompt + " > ");
            String input = in.nextLine().trim();
            result = input.trim();
            if (result.length() == 0) {
                System.out.println("Ungueltige Eingabe!");
            }
        } while (result == null || result.length() == 0);
        return result;
    }

}
