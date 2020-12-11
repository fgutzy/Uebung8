import edu.hm.cs.bka.dev1.city.Stadt;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.platform.commons.support.ModifierSupport;

public class StadtTest {

  @Test
  @Timeout(10)
  public void hatKonstanten() {
    int constants = 0;
    for (Field f : Stadt.class.getDeclaredFields()) {
      if (ModifierSupport.isFinal(f) && ModifierSupport.isStatic(f)) {
        constants++;
      }
    }
    Assertions.assertTrue(constants >= 2, "Es fehlen Konstanten in Klasse Stadt!");
  }

  @Test
  @Timeout(10)
  public void test1DistanceHamburgKarlsruhe() {
    Stadt hamburch = new Stadt("Hamburch", 53.5f, 10.0f, 37);
    double actual = hamburch.berechneAbstand(49.0f, 8.4f);
    double expected = 517.0f;

    Assertions.assertEquals(expected, actual, 10.0,
        "Entfernung Hamburg/Karlsruhe sollte etwa " + expected + "km sein. Ist: " + actual);
  }

  @Test
  @Timeout(10)
  public void test2LatitudeOnly() {
    Stadt stadt = new Stadt("Test", 50f, 10f, 1);
    double actual = stadt.berechneAbstand(51f, 10f);
    Assertions.assertEquals(111.3f, actual, 10.0,
        "Ein Breitengrad sollte 111.3km Entfernung entsprechen, war: " + actual);
  }

  @Test
  @Timeout(10)
  public void test3LongitudeOnly() {
    Stadt stadt = new Stadt("Test", 50f, 10f, 1);
    double actual = stadt.berechneAbstand(50f, 11f);
    Assertions.assertEquals(71.5f, actual, 0.01,
        "Ein Breitengrad sollte 71.5km Entfernung entsprechen, war: " + actual);
  }

}
