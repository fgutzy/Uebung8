package edu.hm.cs.bka.dev1.city;

/**
 * Diese Klasse repraesentiert eine Stadt.
 */
public class Stadt {

  private final String name;
  private final double breitengrad;
  private final double laengengrad;
  private final int einwohner;

  /**
   * Erstellt eine Stadt mit gegebenen Koordinate, Namen und Einwohnerzahl.
   *
   * @param name        Name der Stadt/Gemeinde
   * @param breitengrad Breitengrad
   * @param laengengrad Längengrad
   * @param citizens    Bevölkerungsgröße
   */
  public Stadt(final String name, final double breitengrad, final double laengengrad,
               final int citizens) {
    this.name = name;
    this.breitengrad = breitengrad;
    this.laengengrad = laengengrad;
    this.einwohner = citizens;
  }

  public String getName() {
    return name;
  }

  public double getBreitengrad() {
    return breitengrad;
  }

  public double getLaengengrad() {
    return laengengrad;
  }

  public int getEinwohner() {
    return einwohner;
  }

  /**
   * Berechnet die Entfernung der Stadt von einer gegebenen Position.
   *
   * @param breitengrad Breitengrad der Position zur Abstandsmessung
   * @param laengengrad Längengrad der Position zur Abstandsmessung
   * @return Abstand in km
   */
  public double berechneAbstand(final double breitengrad, final double laengengrad) {
    // TODO: Entfernungsmessung implementieren!
    return 0.0;
  }

}
