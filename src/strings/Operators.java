package strings;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {

        System.out.println('a' + 'b');
        System.out.println('a' + 3);
        System.out.println((char)('a' + 3));
        System.out.println("a" + "b");
        System.out.println("a" + 1);
        //internally it will be changed to "a" + "1"
        //int will be converted to Integer then toString is called

        System.out.println("Anuj" + 'l');
        System.out.println("Anuj" + new int[]{});
        System.out.println("Anuj" + new ArrayList<>());
//        System.out.println(new Integer(3) + new ArrayList<>());
        System.out.println("" + new Integer(3) +  new ArrayList<>());
    }
}
