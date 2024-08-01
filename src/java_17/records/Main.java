package java_17.records;

public class Main {

  public static void main(String[] args) {
    CarWithoutRecord carWithoutRecord = new CarWithoutRecord("23123", "Anuj");
    System.out.println(carWithoutRecord);

    CarRecord carRecord = new CarRecord("23123", "Anuj");
    System.out.println(carRecord);
    System.out.println(carRecord.regNumber());
    System.out.println(carRecord.owner());
  }
}
