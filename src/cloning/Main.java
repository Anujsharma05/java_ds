package cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Human anuj = new Human(23, "Anuj", new Address(34, "New York"));

        //copying object like this is not very efficient
        //because new keyword is cause overhead
//        Human doppelganger = new Human(anuj);
//        System.out.println(doppelganger.name);

        Human doppelganger =  anuj.clone();

        doppelganger.arr[0] = 100;

        System.out.println(Arrays.toString(anuj.arr));
        System.out.println(Arrays.toString(doppelganger.arr));
    }
}
