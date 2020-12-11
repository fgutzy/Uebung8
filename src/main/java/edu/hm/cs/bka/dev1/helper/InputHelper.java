package edu.hm.cs.bka.dev1.helper;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Hilfklasse für Eingaben.
 */
public class InputHelper {

  private static final Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);

  /**
   * Fragt eine Ganzzahl ab.
   *
   * @param prompt Frage
   * @return Eingegebene Ganzzahl
   */
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

  /**
   * Fragt eine Fließkommazahl ab.
   *
   * @param prompt Frage
   * @return Eingegebene Fließkommazahl
   */
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

  /**
   * Fragt einen String ab.
   *
   * @param prompt Frage
   * @return Eingegebener String
   */
  public static String askForString(String prompt) {
    String result;
    do {
      System.out.print(prompt + " > ");
      String input = in.nextLine().trim();
      result = input.trim();
      if (result.length() == 0) {
        System.out.println("Ungueltige Eingabe!");
      }
    } while (result.length() == 0);
    return result;
  }

}
