package edu.hm.cs.bka.dev1.city;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CityDataBase {

  // Dieses Array wird durch den Konstruktor durch Einlesen einer Datei initialisiert!
  private final City[] cities;

  /**
   * Liefert die Liste aller Staedte, die innerhalb des angegebenen Radius um die gegebenen
   * Koordinaten liegen.
   *
   * @param latitude  Breitengrad (Nord) der Anfrage
   * @param longitude Laengengrad (Ost) der Anfrage
   * @param radius    Radius in km
   * @return Array mit den Staedten, die die Anfrage erfuellen
   */
  public City[] findCities(final double latitude, final double longitude, final double radius) {
    //TODO: Erstellen Sie hier ein Array mit allen Städten, die im Radius
    // liegen. Nutzen Sie dafür die implementierte Abstandsmessung!
    return new City[0];
  }

  /* Diesen Teil nicht aendern! Hier wird eine Liste von Staedten aus einer Datei eingelesen. */

  /**
   * Erstellt eine Datenbank auf Basis einer hinterlegten Excel-Datei.
   *
   * @param file Excel-Datei.
   */
  public CityDataBase(String file) {
    cities = readCityDataBase(file);
  }

  private static City[] readCityDataBase(String file) {
    System.out.print("Initialisiere DB...");
    List<City> result = new ArrayList<>();
    try {
      URL resourceUrl = ClassLoader.getSystemResource(file);
      URI resourceUri = new URI(resourceUrl.toString());
      String systemResource = resourceUri.getPath();
      Workbook workbook = WorkbookFactory.create(new File(systemResource));
      Sheet sheet = workbook.getSheetAt(0);

      sheet.forEach(row -> {
        String name = row.getCell(0).toString();
        int citizens = Integer.parseInt(row.getCell(1).toString().replace(" ", ""));
        double latitude = Float.parseFloat(row.getCell(2).toString()) / 1000.0;
        double longitude = Float.parseFloat(row.getCell(3).toString()) / 1000.0;

        City c = new City(name, latitude, longitude, citizens);
        result.add(c);
      });
      workbook.close();

    } catch (Exception e) {
      System.out.println("Datei konnte nicht gelesen werden!");
      System.exit(0);
    }
    System.out.println(result.size() + " Staedte gelesen.");
    return result.toArray(new City[0]);

  }
}
