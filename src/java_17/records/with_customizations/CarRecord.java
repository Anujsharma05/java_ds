package java_17.records.with_customizations;

interface Vehicle {
  void drive(int speed);
}

class CarClass {}
public record CarRecord(String regNumber, String owner) implements Vehicle {

//  private String cannotHaveInstanceVar;

  /**
   * Canonical constructor
   */
//  public CarRecord(String regNumber, String owner) {
//    if(regNumber.length() != 5) {
//      throw new IllegalArgumentException("regNumber length must be 5");
//    }
//    this.regNumber=regNumber;
//    this.owner=owner;
//  }

  /**
   * Compact constructor: without () brackets
   */
  public CarRecord {
    if(regNumber.length() != 5) {
      throw new IllegalArgumentException("regNumber length must be 5");
    }
  }

  /**
   * Non-canonical constructor
   * Calls the compact constructor
   */
  public CarRecord() {
    this("", "");
  }

  private static String currentYear = "24";

  public boolean isNewCar() {
    return regNumber.substring(0,2).equals(currentYear);
  }

  public static CarRecord premadeCar() {
    return new CarRecord("00000", "Dummy");
  }

  @Override
  public String owner() {
    return owner.toUpperCase();
  }

  @Override
  public void drive(int speed) {

  }
}
