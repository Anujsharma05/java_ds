package java_eight.localisation;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalisingNumbers {

  public static void main(String[] args) {
//    formatNumbers();
//    formatCurrencies();
//    parseNumbers();
    parseCurrencies();
  }
  static void formatNumbers() {
    double n = 70_000_000.111;

    //default
    System.out.println(NumberFormat.getInstance().format(n));

    System.out.println(NumberFormat.getInstance(Locale.GERMANY).format(n));
    System.out.println(NumberFormat.getInstance(Locale.FRANCE).format(n));
  }

  static void formatCurrencies() {
    double cost = 23.22;
    System.out.println(NumberFormat.getCurrencyInstance().format(cost));
    System.out.println(NumberFormat.getCurrencyInstance(Locale.FRANCE).format(cost));
    System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(cost));
    System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(cost));
  }

  static void parseNumbers() {
    String unitedStatesNumber = "70,000.11";
    String italianNumber = "70.000,11";
    String frenchNumber = "70000,11";

    try {
      Number num1 = NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber);
      System.out.println(num1);

      System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
      System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  static void parseCurrencies() {
      String usCurrency = "$23.22";
      String ukCurrency = "£23.22";
      String frenchCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(23.22);

    try {
      System.out.println(NumberFormat.getCurrencyInstance(Locale.FRANCE).parse(frenchCurrency));
      System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(usCurrency));
      System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(ukCurrency));
    } catch(ParseException e) {
      e.printStackTrace();
    }
  }
}
