package reflection.section1;

class Car {
    String name;
}

/**
 * Class<?> is the gateway to use reflection
 */
public class WaysToAccessClass {
    public static void main(String[] args) {
        forObjectTypes();
        forPrimitiveTypes();
    }

    static void forPrimitiveTypes() {
        Class<?> c1 = boolean.class;
        Class<?> c2 = int.class;
    }

    static void forObjectTypes() {
        Car car = new Car();

        //Way 1:
        Class<? extends Car> c1 = car.getClass();

        //Way 2:
        Class<Car> c2 = Car.class;

        //Way 3: Prone to runtime error ie least safe
        try {
            Class<?> c3 = Class.forName("reflection.section1.Car");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
