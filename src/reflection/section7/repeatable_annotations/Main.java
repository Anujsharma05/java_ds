package reflection.section7.repeatable_annotations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import reflection.section7.annotation_creation.annotations.ScanPackages;
import reflection.section7.repeatable_annotations.loaders.Cache;

import static reflection.section7.repeatable_annotations.annotations.Annotations.*;

@ScanPackages({"loaders"})
public class Main {

  public static void main(String[] args)
      throws URISyntaxException, IOException, ClassNotFoundException {
    testCode();
//    schedule();
  }

  private static void testCode() {
    Class<Cache> c = Cache.class;
    try {
      Method method = c.getMethod("reloadCache");
//      ExecuteOnSchedule ann = method.getAnnotation(ExecuteOnSchedule.class);
      ExecuteOnSchedule[] anns = method.getAnnotationsByType(ExecuteOnSchedule.class);
      System.out.println(anns.length);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  private static void schedule() throws URISyntaxException, IOException, ClassNotFoundException {

    ScanPackages scanPackages = Main.class.getAnnotation(ScanPackages.class);

      if (scanPackages == null || scanPackages.value().length == 0) {
          return;
      }

    List<Class<?>> allClasses = getAllClasses(scanPackages.value());

    List<Method> scheduledMethods = getScheduledExecutorMethods(allClasses);

    for (Method method : scheduledMethods) {
      scheduleMethodExecution(method);
    }
  }

  private static void scheduleMethodExecution(Method method) {

    ExecuteOnSchedule[] schedules = method.getAnnotationsByType(ExecuteOnSchedule.class);

    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    for (ExecuteOnSchedule schedule : schedules) {
      scheduledExecutorService.scheduleAtFixedRate(
          () -> runWhenScheduled(method),
          schedule.delaySeconds(),
          schedule.periodSeconds(),
          TimeUnit.SECONDS
      );
    }
  }

  private static void runWhenScheduled(Method method) {

    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    System.out.println(String.format("Executing at %s", dateFormat.format(currentDate)));

    try {
      method.invoke(null);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  private static List<Method> getScheduledExecutorMethods(List<Class<?>> allClasses) {

    List<Method> scheduledMethods = new ArrayList<>();
    for (Class<?> clazz : allClasses) {
      if (!clazz.isAnnotationPresent(ScheduledExecutorClass.class)) {
        continue;
      }

      Method[] methods = clazz.getDeclaredMethods();
      for (Method method : methods) {
        if (method.getAnnotationsByType(ExecuteOnSchedule.class).length != 0) {
          scheduledMethods.add(method);
        }
      }
    }
    return scheduledMethods;
  }

  private static List<Class<?>> getAllClasses(String... packageNames)
      throws URISyntaxException, IOException, ClassNotFoundException {
    List<Class<?>> classes = new ArrayList<>();

    for (String packageName : packageNames) {
      String packageRelativePath = packageName.replace(".", "/");

      URI packageURI = reflection.section7.repeatable_annotations.Main.class.getResource(
          packageRelativePath).toURI();

      if (packageURI.getScheme().equals("file")) {
        Path packageFullPath = Paths.get(packageURI);
        classes.addAll(getAllPackageClasses(packageFullPath, packageName));
      } else if (packageURI.getScheme().equals("jar")) {
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

  private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName)
      throws IOException, ClassNotFoundException {

    if (!Files.exists(packagePath)) {
      return Collections.emptyList();
    }

    List<Path> files = Files.list(packagePath)
        .filter(Files::isRegularFile)
        .collect(Collectors.toList());

    List<Class<?>> classes = new ArrayList<>();

    for (Path filePath : files) {
      String fileName = filePath.getFileName().toString();

      if (fileName.endsWith(".class")) {
        String className = packageName.isBlank() ?
            fileName.replaceFirst("\\.class$", "")
            : packageName + "." + fileName.replaceFirst("\\.class$", "");

        String classFullName =
            reflection.section7.repeatable_annotations.Main.class.getPackage().getName() + "."
                + className;
        Class<?> clazz = Class.forName(classFullName);
        classes.add(clazz);
      }
    }
    return classes;
  }
}
