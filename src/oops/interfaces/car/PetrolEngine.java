package oops.interfaces.car;

public class PetrolEngine implements Engine{

    @Override
    public void start() {
        System.out.println("petrol engine starts");
    }

    @Override
    public void stop() {
        System.out.println("petrol engine stops");
    }
}
