package reflection.section8.measuring_dynamic_proxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import reflection.section8.measuring_dynamic_proxy.external.DatabaseReader;
import reflection.section8.measuring_dynamic_proxy.external.HttpClient;
import reflection.section8.measuring_dynamic_proxy.external.impl.DatabaseReaderImpl;
import reflection.section8.measuring_dynamic_proxy.external.impl.HttpClientImpl;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    HttpClient httpClient = createProxy(new HttpClientImpl());
//    useHttpClient(httpClient);

    DatabaseReader dbReader = createProxy(new DatabaseReaderImpl());
    useDatabaseReader(dbReader);
  }

  public static void useHttpClient(HttpClient httpClient) {
    httpClient.initialize();
    String response = httpClient.sendRequest("some request");

    System.out.println(String.format("Http response is : %s", response));
  }

  public static void useDatabaseReader(DatabaseReader databaseReader)
      throws InterruptedException, IOException {
    int rowsInGamesTable = 0;
    try {
      rowsInGamesTable = databaseReader.countRowsInTable("GamesTable");
    } catch(IOException e) {
      System.out.println("Catching Exception: " + e);
      return;
    }

    System.out.println(String.format("There are %s rows in GamesTable", rowsInGamesTable));

    String[] data = databaseReader.readRow("SELECT * from GamesTable");

    System.out.println(String.format("Received %s", String.join(" , ", data)));
  }

  public static <T> T createProxy(Object originalObject) {
      Class<?>[] interfaces = originalObject.getClass().getInterfaces();

      TimeMeasuringProxyHandler timeMeasuringProxyHandler = new TimeMeasuringProxyHandler(originalObject);

      return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
  }

  public static class TimeMeasuringProxyHandler implements InvocationHandler {

    private final Object originalObject;

    public TimeMeasuringProxyHandler(Object originalObject) {
      this.originalObject = originalObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Object result;

      System.out.println(
          String.format("Measuring proxy - Before executing method %s()", method.getName()));

      long startTime = System.currentTimeMillis();
      try {
        result = method.invoke(originalObject, args);
      } catch(InvocationTargetException e) {
        throw e.getTargetException();
      }
      long endTime = System.currentTimeMillis();

      System.out.println();
      System.out.println(
          String.format("Measuring proxyy - Execution of method %s took %d ms", method.getName(),
              endTime - startTime));

      return result;
    }
  }
}
