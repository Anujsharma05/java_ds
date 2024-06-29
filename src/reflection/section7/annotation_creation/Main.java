package reflection.section7.annotation_creation;

import reflection.section7.annotation_creation.annotations.InitializerClass;
import reflection.section7.annotation_creation.annotations.InitializerMethod;
import reflection.section7.annotation_creation.annotations.RetryOperation;
import reflection.section7.annotation_creation.annotations.ScanPackages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ScanPackages(value = {"app", "app.configs", "app.databases", "app.http"})
public class Main {
    public static void main(String[] args) throws Throwable {
        initialize();
    }

    private static void initialize(String ...packageNames) throws Throwable {

        ScanPackages scanPackages = Main.class.getAnnotation(ScanPackages.class);

        if(scanPackages == null || scanPackages.value().length == 0) {
            return;
        }

        List<Class<?>> classes = getAllClasses(scanPackages.value());

        for(Class<?> clazz: classes) {

            /**
             * Ignore unannotated classes
             */
            if(!clazz.isAnnotationPresent(InitializerClass.class)) {
                continue;
            }

            /**
             * Create object using default constructor
             */
            Object instance = clazz.getDeclaredConstructor().newInstance();

            List<Method> methods = getAllInitializingMethods(clazz);

            for(Method method: methods) {
                callInitializingMethod(instance, method);
            }
        }
    }

    private static void callInitializingMethod(Object instance, Method method) throws Throwable {

        RetryOperation retryOperation = method.getAnnotation(RetryOperation.class);

        int numberOfRetries = retryOperation == null ? 0 :retryOperation.numberOfRetries();

        while(true) {
            try {
                method.invoke(instance);
                break;
            } catch(InvocationTargetException ex) {
                Throwable targetException = ex.getTargetException();

                if(numberOfRetries > 0 && Set.of(retryOperation.retryException()).contains(targetException.getClass())) {
                    numberOfRetries--;
                    System.out.println("Retrying...");
                } else if(retryOperation != null) {
                    throw new Exception(retryOperation.failureMessage(), targetException);
                } else {
                    throw targetException;
                }
            }
        }
    }
    private static List<Method> getAllInitializingMethods(Class<?> clazz) {

        return Stream.of(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(InitializerMethod.class))
                .collect(Collectors.toList());
    }
    private static List<Class<?>> getAllClasses(String ...packageNames) throws URISyntaxException, IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        for(String packageName: packageNames) {
            String packageRelativePath = packageName.replace(".", "/");

            URI packageURI = Main.class.getResource(packageRelativePath).toURI();

            if(packageURI.getScheme().equals("file")) {
                Path packageFullPath = Paths.get(packageURI);
                classes.addAll(getAllPackageClasses(packageFullPath, packageName));
            } else if(packageURI.getScheme().equals("jar")) {
                FileSystem fileSystem = FileSystems.newFileSystem(packageURI, Collections.emptyMap());

                Path packageFullPathInJar = fileSystem.getPath(packageRelativePath);
                classes.addAll(getAllPackageClasses(packageFullPathInJar, packageName));
                /**
                 * So that it can be accessed in next iteration
                 */
                fileSystem.close();
            }
        }
        return classes;
    }
    private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName) throws IOException, ClassNotFoundException {

        if(!Files.exists(packagePath)) {
            return Collections.emptyList();
        }

        List<Path> files = Files.list(packagePath)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());


        List<Class<?>> classes = new ArrayList<>();

        for(Path filePath: files) {
            String fileName = filePath.getFileName().toString();

            if (fileName.endsWith(".class")) {
                String className = packageName.isBlank() ?
                        fileName.replaceFirst("\\.class$", "")
                        : packageName + "." + fileName.replaceFirst("\\.class$", "");

                String classFullName = Main.class.getPackage().getName() + "." + className;
                Class<?> clazz = Class.forName(classFullName);
                classes.add(clazz);
            }
        }
        return classes;
    }
}
