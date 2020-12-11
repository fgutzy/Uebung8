package edu.hm.cs.bka.dev1.city;

import edu.hm.cs.bka.dev1.helper.InputHelper;
import java.io.IOException;

import javax.swing.*;
import org.apache.poi.EncryptedDocumentException;

public class CityDemo {

  public static void main(String[] args) throws EncryptedDocumentException, IOException {
    CityDataBase cityDb = new CityDataBase("cities.xlsx");

    double latitude = InputHelper.askForFloat("Breitengrad (z.B. 50.0)");
    double longitude = InputHelper.askForFloat("Laengengrad (z.B. 10.0)");
    double radius = InputHelper.askForFloat("Radius in km (z.B. 20.0)");

    City[] searchResult = cityDb.findCities(latitude, longitude, radius);

    System.out.println("Staedte im Suchbereich:");
    int totalPopulation = 0;
    for (City city: searchResult) {
      System.out.print("  ");
      System.out.println(city.getName());
      totalPopulation += city.getPopulation();
    }
    System.out.println("Einwohner gesamt: " + totalPopulation);
  }

}
