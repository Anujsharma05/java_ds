package reflection.section5.method_invocation;

import reflection.section5.method_invocation.database.DatabaseClient;
import reflection.section5.method_invocation.http.HttpClient;
import reflection.section5.method_invocation.logging.FileLogger;
import reflection.section5.method_invocation.udp.UdpClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Throwable {
        DatabaseClient dbClient = new DatabaseClient();
        HttpClient http1 = new HttpClient("192.44.33.11");
        HttpClient http2 = new HttpClient("102.4.2.4");
        FileLogger logger = new FileLogger();
        UdpClient udpClient = new UdpClient();

        String requestBody = "request data";

        List<Class<?>> methodParameterTypes = Arrays.asList(new Class<?>[] {String.class});
        Map<Object, Method> requestExecutors = groupExecutors(Arrays.asList(dbClient, http1, http2, logger, udpClient), methodParameterTypes);

        executeAll(requestExecutors, requestBody);
    }

    /**
     * @throws InvocationTargetException - If the method called throws an exception, it is wrapped inside this exception
     */
    public static void executeAll(Map<Object, Method> requestExecutors, String requestBody) throws Throwable {
        try {
            for(Map.Entry<Object, Method> entry: requestExecutors.entrySet()) {
                Object executor = entry.getKey();
                Method method = entry.getValue();

                /**
                 * If a primitive type is returned from the method,
                 * It will be always be boxed into its Wrapper class
                 */
                Boolean result = (Boolean) method.invoke(executor, requestBody);

                System.out.println(String.format("Method: %s invocation result is: %s",method.getName(), result));
            }
        } catch(InvocationTargetException ex) {
            /**
             * Throwing the wrapped exception
             */
            throw ex.getTargetException();
        }
    }
    public static Map<Object, Method> groupExecutors(List<Object> requestExecutors, List<Class<?>> methodParameterTypes) {

        Map<Object, Method> instanceToMethod = new HashMap<>();

        for(Object executor: requestExecutors) {
            Method[] allMethods = executor.getClass().getDeclaredMethods();

            for(Method method: allMethods) {
                if(Arrays.asList(method.getParameterTypes()).equals(methodParameterTypes)) {
                    instanceToMethod.put(executor, method);
                }
            }
        }
        return instanceToMethod;
    }
}
