package enums_switch;

import java.time.Month;

public class SwitchExample {
    public static void main(String[] args) {
        String day = "wednesday";

        String s = switch(day) {
            case "monday", "wednesday" -> {
                String d;
                if("monday".equals(day)) {
                    d = "monday";
                } else {
                    d = "wednesday";
                }
                //returns value when using curly brace code block
                yield d;
            }
            case "tuesday" -> "tuesday";
            default -> "any other day";
        };

        Month month = Month.JUNE;
        var result = switch(month) {
            case JANUARY, JUNE, JULY -> 3;
            case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
//            case MARCH, MAY, APRIL, AUGUST -> 2;
            default -> 0;
        };

        System.out.println(s);
        System.out.println(result);
    }
}
