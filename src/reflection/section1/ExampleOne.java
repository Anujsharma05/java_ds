package reflection.section1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExampleOne {

    interface Drawable {
        int getNumberOfCorners();
    }

    class Square implements Drawable {
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private enum Color {
        RED,
        BlUE,
        GREEN
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> map = new HashMap<>();
        Class<?> mapClass = map.getClass();

        Class<?> squareClass = Class.forName("reflection.section1.ExampleOne$Square");

//        printClassInfo(stringClass, mapClass, squareClass);

        Drawable circleObject = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

        printClassInfo(Collection.class, Drawable.class, boolean.class, int[][].class, Color.class, circleObject.getClass());
    }
    public static void printClassInfo(Class<?> ...classes) {
        for(Class<?> clazz: classes) {
            System.out.println(String.format("Class name: %s, Class package name: %s",
                    clazz.getSimpleName(), clazz.getPackageName()));

            Class<?> [] implementedInterfaces = clazz.getInterfaces();

            for(Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("Class %s implements %s",
                        clazz.getSimpleName(), implementedInterface.getSimpleName()));
            }

            System.out.println("Is Array: " + clazz.isArray());
            System.out.println("Is Primitive: " + clazz.isPrimitive());
            System.out.println("Is Enum: " + clazz.isEnum());
            System.out.println("Is Interface: " + clazz.isInterface());
            System.out.println("Is Anonymous: " + clazz.isAnonymousClass());

            System.out.println();
            System.out.println();
        }
    }
}
