package reflection.section5.exercise;

import java.util.*;
import java.lang.reflect.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingFramework {
    public static void main(String[] args) throws Throwable {

        TestingFramework framework = new TestingFramework();
        framework.runTestSuite(PaymentServiceTest.class);
    }
    public void runTestSuite(Class<?> testClass) throws Throwable {
        Method[] allMethods = testClass.getMethods();

        Method before = findMethodByName(allMethods, "beforeClass");
        if(before != null ) {
            before.invoke(null);
        }

        Constructor constructor = testClass.getDeclaredConstructor();
        Object object = constructor.newInstance();

        List<Method> testMethods = findMethodsByPrefix(allMethods, "test");

        Method setupTest = findMethodByName(allMethods, "setupTest");

        for(Method testMethod: testMethods) {
            if(setupTest != null) {
                setupTest.invoke(object);
            }
            testMethod.invoke(object);
        }

        Method after = findMethodByName(allMethods, "afterClass");
        if(after != null) {
            after.invoke(null);
        }
    }

    /**
     * Helper method to find a method by name
     * Returns null if a method with the given name does not exist
     */
    private Method findMethodByName(Method[] methods, String name) {
        return Stream.of(methods)
                .filter(method -> method.getName().equals(name))
                .filter(method -> method.getParameterCount() == 0)
                .filter(method -> method.getReturnType().equals(void.class))
                .findFirst().orElseGet(() -> null);
    }

    /**
     * Helper method to find all the methods that start with the given prefix
     */
    private List<Method> findMethodsByPrefix(Method[] methods, String prefix) {
        return Stream.of(methods)
                .filter(method -> method.getName().startsWith(prefix))
                .filter(method -> method.getParameterCount() == 0)
                .filter(method -> method.getReturnType().equals(void.class))
                .collect(Collectors.toList());
    }
}