package edu.hm.cs.bka.dev1.city;

import edu.hm.cs.bka.dev1.helper.InputHelper;

/**
 * Kleine Anwendung zur Ermittelung der Einwohnerdichte in Gebieten Deutschlands.
 */
public class StadtDemo {

  /**
   *  Hauptprogramm.
   *
   * @param args wird nicht verwendet
   */
  public static void main(String[] args)  {
    StadtDatenbank datenbank = new StadtDatenbank("cities.xlsx");

    double breitengrad = InputHelper.askForFloat("Breitengrad (z.B. 50.0)");
    double laengengrad = InputHelper.askForFloat("Laengengrad (z.B. 10.0)");
    double radius = InputHelper.askForFloat("Radius in km (z.B. 20.0)");

    Stadt[] staedteInRadius = datenbank.findeStaedte(breitengrad, laengengrad, radius);

    System.out.println("Staedte im Suchbereich:");
    int gesamtEinwohner = 0;
    for (Stadt stadt : staedteInRadius) {
      System.out.print("  ");
      System.out.println(stadt.getName());
      gesamtEinwohner += stadt.getEinwohner();
    }
    System.out.println("Einwohner gesamt: " + gesamtEinwohner);
  }

}
