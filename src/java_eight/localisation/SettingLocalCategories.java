package java_eight.localisation;

import java.util.Locale;
import java.util.Locale.Category;

public class SettingLocalCategories {

  public static void main(String[] args) {
    double n = 77000.12;
    Locale locFrench = Locale.FRANCE;

    Locale defaultLocale = Locale.getDefault();

    Locale.setDefault(Category.DISPLAY, locFrench);

    System.out.println(defaultLocale.getDisplayName());
    System.out.println(defaultLocale.getDisplayLanguage());
    System.out.println(defaultLocale.getDisplayCountry());

  }
}
