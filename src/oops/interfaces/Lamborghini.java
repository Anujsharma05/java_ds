package oops.interfaces;

interface Vehicle {
    public abstract void move();
}

interface Car {
    void move();
}
class SportsCar implements Vehicle, Car{

    @Override
    public void move() {
        System.out.println("moving");
    }
}

public class Lamborghini {
    public static void main(String[] args) {
        SportsCar lambo = new SportsCar();
        lambo.move();
    }
}


