package reflection.section7.Exercise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnnotationDiscovery {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        AnnotationDiscovery ad = new AnnotationDiscovery();
        SomeClass sc = ad.new SomeClass();
        Set<Method> methods = ad.getAllAnnotatedMethods(sc);

        for(Method method: methods) {
//            if(Modifier.isPrivate(method.getModifiers())) {
//                method.setAccessible(true);
//            }
            method.invoke(sc);
        }
    }
    public class SomeClass {
        @OpenResources
        public void someMethod1() {
            System.out.println("method 1");
        }
        @OpenResources
        private void someMethod2() {
            System.out.println("Method 2");
        }
        public void someMethod3() {
            System.out.println("Method 3");
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface OpenResources {

    }

    public Set<Method> getAllAnnotatedMethods(Object input) {
        Method[] methods = input.getClass().getDeclaredMethods();

        return Stream.of(methods)
                .filter(method -> method.isAnnotationPresent(OpenResources.class))
                .collect(Collectors.toSet());

    }
}