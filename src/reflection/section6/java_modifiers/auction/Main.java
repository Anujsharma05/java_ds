package reflection.section6.java_modifiers.auction;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * int modifier = class.getModifiers()
 * int modifier = method.getModifiers()
 * int modifier = field.getModifiers()
 *
 * int modifier stores all the modifiers in bitmap
 * ie. we can check the modifiers using bitwise AND operation
 * between modifier and their bitmasks(Ex Modifier.FINAL or Modifier.PRIVATE)
 *
 * Or we could use Modifier helper class(Ex. Modifier.isPrivate(modifier))
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
//        classModifiers();
//        methodModifiers();
        fieldModifiers();
    }
    public static void fieldModifiers() {
        printFieldModifiers(Auction.class.getDeclaredFields());
        System.out.println("===================================");
        printFieldModifiers(Bid.class.getDeclaredFields());
    }
    public static void methodModifiers() {
        printMethodModifiers(Auction.class.getDeclaredMethods());
        System.out.println("===================================");
        printMethodModifiers(Bid.class.getDeclaredMethods());
        System.out.println("===================================");
        printMethodModifiers(Bid.Builder.class.getDeclaredMethods());
    }
    public static void classModifiers() throws ClassNotFoundException {
        printClassModifiers(Bid.class);
        System.out.println("===================================");
        printClassModifiers(Serializable.class);
        System.out.println("===================================");
        printClassModifiers(Class.forName("reflection.section6.java_modifiers.auction.Bid$Builder$BidImpl"));
    }
    private static void printFieldModifiers(Field[] fields) {
        for(Field field: fields) {
            int modifiers = field.getModifiers();

            System.out.println(String.format("Field \"%s\" access modifier is %s",
                    field.getName(),
                    getAccessModifierName(modifiers)));

            if(Modifier.isVolatile(modifiers)) {
                System.out.println("Field is volatile");
            }
            if(Modifier.isFinal(modifiers)) {
                System.out.println("Field is final");
            }
            if(Modifier.isTransient(modifiers)) {
                System.out.println("Field is transient");
            }
            System.out.println();
        }
    }
    private static void printMethodModifiers(Method[] methods) {
        for(Method method: methods) {
            int modifiers = method.getModifiers();

            System.out.println(String.format("%s() method has %s access modifier",
                    method.getName(),
                    getAccessModifierName(modifiers)));

            if(Modifier.isSynchronized(modifiers)) {
                System.out.println(String.format("%s() method is synchronized", method.getName()));
            } else {
                System.out.println(String.format("%s() method is not synchronized", method.getName()));
            }
            System.out.println();
        }
    }
    private static void printClassModifiers(Class<?> clazz) {
        int modifiers = clazz.getModifiers();

        System.out.println(String.format("Class %s access modifier is %s",
                clazz.getSimpleName(),
                getAccessModifierName(modifiers)));

        if(Modifier.isAbstract(modifiers)) {
            System.out.println("Class is an abstract class");
        }
        if(Modifier.isInterface(modifiers)) {
            System.out.println("Class is an Interface");
        }
        if(Modifier.isStatic(modifiers)) {
            System.out.println("Class is a static class");
        }

    }
    private static String getAccessModifierName(int modifier) {
        if(Modifier.isPublic(modifier)) {
            return "public";
        } else if(Modifier.isProtected(modifier)) {
            return "protected";
        } else if(Modifier.isPrivate(modifier)) {
            return "private";
        } else {
            return "package-private";
        }
    }
    public static void runAuction() {
        Auction auction = new Auction();

        auction.startAuction();

        Bid bid1 = Bid.builder()
                .setPrice(11)
                .setBidderName("Company1")
                .build();

        Bid bid2 = Bid.builder()
                .setPrice(14)
                .setBidderName("Company2")
                .build();

        auction.addBid(bid1);
        auction.addBid(bid2);

        auction.stopAuction();

        System.out.println(auction.getAllBids());
        System.out.println(String.format("Highest Bid: %s", auction.getHighestBid().get()));

    }
}
