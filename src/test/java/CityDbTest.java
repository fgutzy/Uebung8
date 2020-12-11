import edu.hm.cs.bka.dev1.city.City;
import edu.hm.cs.bka.dev1.city.CityDataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityDbTest {

  private CityDataBase sut;

  @BeforeEach
  public void setup() {
    sut = new CityDataBase("cities.xlsx");
  }

  @Test
  public void test1() {
    City[] result = sut.findCities(50, 10, 20);
    City[] allCities = sut.findCities(50, 10, 20000);
    Assertions.assertEquals(4,
        result.length, "Suche um 50N, 10N im Radius 20km sollte 4 Staedte zurückliefern.");
    City[] expected = new City[4];
    for (City city : allCities) {
      if (city.getName().equals("Arnstein")) {
        expected[0] = city;
      } else if (city.getName().equals("Hammelburg")) {
        expected[1] = city;
      } else if (city.getName().equals("Karlstadt")) {
        expected[2] = city;
      } else if (city.getName().equals("Schweinfurt")) {
        expected[3] = city;
      }
    }

    Assertions.assertArrayEquals(expected, result, "Falsche Staedte im Ergebnis bei Suche um 50N, 10N im Radius 20km.");
  }


}
