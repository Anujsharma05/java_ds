package reflection.section8.exercise;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Date;

public class Main {
  public static void main(String[] args) throws IOException {
//    withoutCachingImplementation();
    withCachingImplementation();
  }

  public static void withoutCachingImplementation() throws IOException {
    DatabaseReader dbReader = new DatabaseReaderImpl();
    dbReader.connectToDatabase();
    dbReader.addCustomer("1", "Anuj", "Sharma");
    int rows = dbReader.countRowsInCustomersTable();
    Date birthday = dbReader.readCustomerBirthday("1");
    String customerId = dbReader.readCustomerIdByName("Anuj", "Sharma");
  }

  public static void withCachingImplementation() {
    DatabaseReader dbReader = createProxy(new DatabaseReaderImpl());
    dbReader.readCustomerBirthday("1");
    try {
     dbReader.readCustomerIdByName("Anuj", "Sharma");
      dbReader.readCustomerIdByName("Anuj", "Sharma");
      dbReader.readCustomerIdByName("Anuj", "Sharma");
    } catch (IOException e) {
      System.out.println("Exception caught: " + e);
    }
    dbReader.readCustomerBirthday("1");
    dbReader.readCustomerBirthday("1");
    dbReader.readCustomerBirthday("1");
  }

  public static <T> T createProxy(Object realObject) {
    Class<?>[] interfaces = realObject.getClass().getInterfaces();
    CachingInvocationHandler handler = new CachingInvocationHandler(realObject);
    return (T) Proxy.newProxyInstance(realObject.getClass().getClassLoader(), interfaces, handler);
  }
}
