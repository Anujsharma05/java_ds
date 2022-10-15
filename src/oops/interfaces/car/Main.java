package oops.interfaces.car;

public class Main {
    public static void main(String[] args) {
        Car maruti = new Car(new PetrolEngine(), new CdPlayer());
        maruti.startEngine();

        Car tesla = new Car(new ElectricEngine(), new CdPlayer());
        tesla.startEngine();
    }
}
