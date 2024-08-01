package java_eight.localisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalisingDates {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();

    DateTimeFormatter localizedDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

    System.out.println(localizedDateTime.format(now));
  }
}
