package oops.interfaces.car;

public class ElectricEngine implements Engine{

    @Override
    public void start() {
        System.out.println("electric engine starts");
    }

    @Override
    public void stop() {
        System.out.println("electric engine stops");
    }
}
