import edu.hm.cs.bka.dev1.city.Stadt;
import edu.hm.cs.bka.dev1.city.StadtDatenbank;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class StadtDatenbankTest {

  private StadtDatenbank sut;

  @BeforeEach
  public void setup() {
    sut = new StadtDatenbank("cities.xlsx");
  }

  @Test
  @Timeout(30)
  public void test1() {
    Stadt[] result = sut.findeStaedte(50, 10, 20);
    Stadt[] allCities = sut.findeStaedte(50, 10, 20000);
    Assertions.assertEquals(4,
        result.length, "Suche um 50N, 10N im Radius 20km sollte 4 Staedte zurückliefern.");
    Stadt[] expected = new Stadt[4];
    for (Stadt stadt : allCities) {
      if (stadt.getName().equals("Arnstein")) {
        expected[0] = stadt;
      } else if (stadt.getName().equals("Hammelburg")) {
        expected[1] = stadt;
      } else if (stadt.getName().equals("Karlstadt")) {
        expected[2] = stadt;
      } else if (stadt.getName().equals("Schweinfurt")) {
        expected[3] = stadt;
      }
    }

    Assertions.assertArrayEquals(expected, result, "Falsche Staedte im Ergebnis bei Suche um 50N, 10N im Radius 20km.");
  }


}
