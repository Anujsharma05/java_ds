package java_17.records.with_customizations;

public class Main {

  public static void main(String[] args) {
    CarRecord carRecord = new CarRecord("24345", "Max Verstappen");
    System.out.println(carRecord.isNewCar());
    System.out.println(CarRecord.premadeCar());
    System.out.println(carRecord.owner());
  }
}
