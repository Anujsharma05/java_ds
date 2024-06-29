package reflection.section8.exercise;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class DatabaseReaderImpl implements DatabaseReader{

  @Override
  public void connectToDatabase() {
    System.out.println("Connect to database");
  }

  @Override
  public String readCustomerIdByName(String firstName, String lastName) throws IOException {
    System.out.println("Reading customer id by name");
    return "10";
  }

  @Override
  public int countRowsInCustomersTable() {
    System.out.println("Count rows in customers table");
    return 10;
  }

  @Override
  public void addCustomer(String id, String firstName, String lastName) throws IOException {
    System.out.println("Adding customer");
  }

  @Override
  public Date readCustomerBirthday(String id) {
    System.out.println("Reading customer birthday");
    return Date.from(Instant.now());
  }
}
