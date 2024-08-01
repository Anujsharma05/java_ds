package java_eight.localisation;

import java.util.Locale;

public class CreateLocale {

  public static void main(String[] args) {
    throughConstructor();
    throughBuiltInConstants();
    throughBuilderPattern();
  }

  private static void throughConstructor() {
    Locale locale = new Locale("en", "GB");
    System.out.println(locale.getDisplayLanguage());
    System.out.println(locale.getDisplayCountry());

    System.out.println(new Locale("xyz", "abc"));
  }

  private static void throughBuiltInConstants() {
    Locale locale = Locale.ITALY;
    System.out.println(locale.getDisplayLanguage());
    System.out.println(locale.getDisplayCountry());

    System.out.println(Locale.ITALIAN);
  }

  private static void throughBuilderPattern() {
    Locale locale = new Locale.Builder()
        .setLanguage("ar")
        .setRegion("EG")
        .build();
    System.out.println(locale.getDisplayLanguage());
    System.out.println(locale.getDisplayCountry());
  }
}
