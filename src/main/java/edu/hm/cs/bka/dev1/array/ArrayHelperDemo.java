package edu.hm.cs.bka.dev1.array;

/**
 * Demonstration der Klasse {@link ArrayHelper}
 */
public class ArrayHelperDemo {

  public static void main(String[] args) {
    System.out.println("Beispiele für die Nutzung von ArrayHelper:");

    // Demonstration von Aufgabe 28 A
    int[] spanDemo = {17, 3, 4, 9, 31, 15, 6, 2, 9, 10};
    System.out.print("Abstand zwischen Minimum und Maximum sollte 29 betragen: ");
    System.out.println(ArrayHelper.maxDiff(spanDemo));

    // Demonstration von Aufgabe 28 B
    int[] coverDemo = {17, 3, 4, 9, 31, 5, 6, 2, 9, 10};
    System.out.print("Enthalten  der Zahlen 2, 4, 6 sollte true ergeben: ");
    System.out.println(ArrayHelper.containsAll(coverDemo, 2, 4, 6));

    System.out.print("Abdeckung der Zahlen 3, 6, 8, 9 sollte false ergeben: ");
    System.out.println(ArrayHelper.containsAll(coverDemo, 3, 6, 8, 9));

  }
}
