import edu.hm.cs.bka.dev1.array.ArrayHelper;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


import static org.junit.jupiter.api.Assertions.*;

public class ArrayHelperTest {

  @Test
  @Timeout(10)
  public void test1span() {
    int[] sample = {17, 3, 4, 9, 31, 15, 6, 2, 9, 10};
    assertEquals(29, ArrayHelper.maxDiff(sample),
        "Differenz zwischen kleinstem und groesstem Wert von "
            + ArrayUtils.toString(sample) + " sollte 29 sein!");
  }

  @Test
  @Timeout(10)
  public void test2spanWithNegativeNumber() {
    int[] sample = {17, -9, 31, 6, 1000, 9};
    assertEquals(1009, ArrayHelper.maxDiff(sample),
        "Differenz zwischen kleinstem und groesstem Wert von "
            + ArrayUtils.toString(sample) + " sollte 1009 sein!");
  }

  @Test
  @Timeout(10)
  public void test3spanWithNegativeNumber() {
    int[] sample = {-17, -9, -31, -6, -100, -9};
    assertEquals(94, ArrayHelper.maxDiff(sample),
        "Differenz zwischen kleinstem und groesstem Wert von "
            + ArrayUtils.toString(sample) + " sollte 94 sein!");
  }

  @Test
  @Timeout(10)
  public void test4spanOfSingleElementArray() {
    int[] sample = {32};
    assertEquals(0, ArrayHelper.maxDiff(sample),
        "Differenz zwischen kleinstem und groesstem Wert von "
            + ArrayUtils.toString(sample) + " sollte 0 sein!");
  }

  @Test
  @Timeout(10)
  public void test5spanOfEmptyArray() {
    int[] sample = {};
    assertEquals(0, ArrayHelper.maxDiff(sample),
        "Differenz zwischen kleinstem und groesstem Wert von "
            + ArrayUtils.toString(sample) + " sollte 0 sein!");
  }

  @Test
  @Timeout(10)
  public void test1CoverReturnsTrue() {
    int[] array = {17, 3, 4, 9, 31, 5, 6, 2, 9, 10};
    assertTrue(ArrayHelper.containsAll(array, 2, 4, 6),
        "Nicht erkannt: Array " + ArrayUtils.toString(array) + " enthaelt 2,4 und 6!");
  }

  @Test
  @Timeout(10)
  public void test2CoverReturnsFalse() {
    int[] array = {17, 3, 4, 9, 31, 5, 6, 2, 9, 10};
    assertFalse(ArrayHelper.containsAll(array, 3, 6, 8, 9),
        "Nicht erkannt: Array " + ArrayUtils.toString(array)
            + " enthaelt nicht 3, 6, 8 und 9!");
  }

  @Test
  @Timeout(10)
  public void test3CoverReturnsTrueForEmptyVarargs() {
    int[] array = {1, 2, 3, 9, 31, 5, 6, 2, 9, 10};
    assertTrue(ArrayHelper.containsAll(array),
        "Nicht erkannt: Array " + ArrayUtils.toString(array)
            + " enthaelt per Definition die leere Menge!");
  }

  @Test
  @Timeout(10)
  public void test4CoverReturnsFalseForEmptyArrayAndNonemptyVarargs() {
    int[] array = {};
    assertFalse(ArrayHelper.containsAll(array, 0),
        "Nicht erkannt: Leeres Array enthaelt nicht 0!");
  }

  @Test
  @Timeout(10)
  public void test5CoverReturnsTrueForEmptyArrayAndEmptyVarargs() {
    int[] array = {};
    assertTrue(ArrayHelper.containsAll(array),
        "Nicht erkannt: Leeres Array per Definition die leere Menge!");
  }

}
