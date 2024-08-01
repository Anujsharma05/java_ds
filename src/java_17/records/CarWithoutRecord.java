package java_17.records;

public class CarWithoutRecord {

  private final String regNumber;
  private final String owner;

  public CarWithoutRecord(String regNumber, String owner) {
    this.regNumber = regNumber;
    this.owner = owner;
  }

  public String getRegNumber() {
    return regNumber;
  }

  public String getOwner() {
    return owner;
  }

  @Override
  public String toString() {
    return "CarWithoutRecord{" +
        "regNumber='" + regNumber + '\'' +
        ", owner='" + owner + '\'' +
        '}';
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }
}
