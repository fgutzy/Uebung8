import static org.junit.jupiter.api.Assertions.*;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTestHelper {


  public static Class<?> assertClass(String pck, String className) {
    String fqnClassName = pck + "." + className;
    if (pck == "") {
      fqnClassName = className;
    }
    try {
      Class<?> clazz = Class.forName(fqnClassName);
      return clazz;
    } catch (ClassNotFoundException e) {
      fail("Klasse fehlt: " + fqnClassName);
    }
    return null;
  }

  public static Constructor<?> assertPublicConstructor(Class<?> clazz,
                                                       Class<?>... parameterTypes) {
    try {
      Constructor<?> c = clazz.getDeclaredConstructor(parameterTypes);
      assertTrue(Modifier.isPublic(c.getModifiers()),
          "Falsche Sichtbarkeit von Konstruktor der Klasse " + clazz.getName());
      return c;
    } catch (NoSuchMethodException e) {
      fail("Construktor fehlt oder hat falsche Parametertypen: " + clazz.getName());
    } catch (SecurityException e) {
      fail("Konstruktor kann nicht zugegriffen werden: " + clazz.getName());
    }
    return null;
  }

  public static Method assertPublicMethod(Class<?> clazz, String name, Class<?> returnType,
                                          Class<?>... parameterTypes) {
    try {
      Method m = clazz.getDeclaredMethod(name, parameterTypes);
      assertEquals(returnType, m.getReturnType(),
          "Falscher Rueckgabetyp von Methode " + name + " in Klasse " + clazz.getName());
      assertTrue(Modifier.isPublic(m.getModifiers()),
          "Falsche Sichtbarkeit von Methode " + name + " in Klasse " + clazz.getName());
      return m;
    } catch (NoSuchMethodException e) {
      fail("Methode fehlt oder hat falsche Parametertypen: " + name + " in Klasse "
          + clazz.getName());
    } catch (SecurityException e) {
      fail("Methode kann nicht zugegriffen werden: " + name + "in Klasse " + clazz.getName());
    }

    return null;
  }

  public static Method assertPrivateMethod(Class<?> clazz, String name, Class<?> returnType,
                                          Class<?>... parameterTypes) {
    try {
      Method m = clazz.getDeclaredMethod(name, parameterTypes);
      assertEquals(returnType, m.getReturnType(),
          "Falscher Rueckgabetyp von Methode " + name + " in Klasse " + clazz.getName());
      assertTrue(Modifier.isPrivate(m.getModifiers()),
          "Falsche Sichtbarkeit von Methode " + name + " in Klasse " + clazz.getName());
      return m;
    } catch (NoSuchMethodException e) {
      fail("Methode fehlt oder hat falsche Parametertypen: " + name + " in Klasse "
          + clazz.getName());
    } catch (SecurityException e) {
      fail("Methode kann nicht zugegriffen werden: " + name + " in Klasse " + clazz.getName());
    }

    return null;
  }

  public static Field assertPrivateField(Class<?> clazz, String name, Class<?> type) {
    Field m = null;
    try {
       m = clazz.getDeclaredField(name);
      assertEquals(type, m.getType(),
          "Falscher Typ von Variable " + name + " in Klasse " + clazz.getName());
      assertTrue(Modifier.isPrivate(m.getModifiers()),
          "Falsche Sichtbarkeit von Variable " + name + " in Klasse " + clazz.getName());
      return m;
    } catch (NoSuchFieldException e) {
      fail("Objektvariable fehlt: " + name + " in Klasse "
          + clazz.getName());
    }
    return m;
  }

}
