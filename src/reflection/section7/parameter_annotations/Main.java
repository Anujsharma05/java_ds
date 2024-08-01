package reflection.section7.parameter_annotations;

import java.lang.reflect.Field;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import reflection.section7.parameter_annotations.annotations.Annotations;

import static reflection.section7.parameter_annotations.annotations.Annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Annotations class is static imported
 */
public class Main {

  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
//        withoutAnnotations();
    withAnnotations();
  }

  /**
   * Here we have to call all the methods in right order because one method depends on the result of
   * another method
   */
  private static void withoutAnnotations() {
    BestGamesFinder bestGamesFinder = new BestGamesFinder();

    Set<String> allGames = bestGamesFinder.getAllGames();

    Map<String, Float> gameToRating = bestGamesFinder.getGameToRating(allGames);
    Map<String, Float> gameToPrice = bestGamesFinder.getGameToPrice(allGames);

    SortedMap<Double, String> gameToScore = bestGamesFinder.scoreGames(gameToPrice, gameToRating);

    List<String> bestGamesInDescendingOrder = bestGamesFinder.getTopGames(gameToScore);

    System.out.println(bestGamesInDescendingOrder);
  }

  private static void withAnnotations()
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

    bestGameFinder();
//    sqlQueryBuilder();
  }

  private static void bestGameFinder()
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
      BestGamesFinder bestGamesFinder = new BestGamesFinder();
      List<String> bestGamesInDescendingOrder = execute(bestGamesFinder);
      System.out.println(bestGamesInDescendingOrder);
  }

  private static void sqlQueryBuilder()
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
      SqlQueryBuilder sqlQuery = new SqlQueryBuilder(Arrays.asList("1", "2", "3"), 10, "movies", Arrays.asList("Id", "Name") );

      Long sqlQueryString = execute(sqlQuery);
      System.out.println(sqlQueryString);
  }

  private static <T> T execute(Object instance)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Class<?> clazz = instance.getClass();

    Map<String, Method> operationToMethod = getOperationToMethod(clazz);
    Map<String, Field> inputToField = getInputToField(clazz);

    Method finalResultMethod = findFinalResultMethod(clazz);

    return (T) executeWithDependencies(instance, finalResultMethod, operationToMethod, inputToField);
  }

  private static Object executeWithDependencies(Object instance, Method currentMethod,
      Map<String, Method> operationToMethod, Map<String, Field> inputToField)
      throws InvocationTargetException, IllegalAccessException {

    List<Object> parameterValues = new ArrayList<>(currentMethod.getParameterCount());

    Parameter[] parameters = currentMethod.getParameters();

    for (Parameter parameter : parameters) {
      if (parameter.isAnnotationPresent(DependsOn.class)) {
        DependsOn annotation = parameter.getAnnotation(DependsOn.class);
        String dependencyOperationName = annotation.value();

        Method dependencyMethod = operationToMethod.get(dependencyOperationName);

        Object methodResult = executeWithDependencies(instance, dependencyMethod,
            operationToMethod, inputToField);

        parameterValues.add(methodResult);
      } else if(parameter.isAnnotationPresent(Input.class)) {
          Input input = parameter.getAnnotation(Input.class);

          Field field = inputToField.get(input.value());
          field.setAccessible(true);

          Object fieldValue = field.get(instance);

          parameterValues.add(fieldValue);
      }
    }

    return currentMethod.invoke(instance, parameterValues.toArray());
  }

  private static Map<String, Method> getOperationToMethod(Class<?> clazz) {

    Map<String, Method> operationToMethodMap = new HashMap<>();

    Method[] methods = clazz.getDeclaredMethods();

    for (Method method : methods) {
      if (method.isAnnotationPresent(Annotations.Operation.class)) {
        Annotations.Operation operation = method.getAnnotation(Annotations.Operation.class);
        operationToMethodMap.put(operation.value(), method);
      }
    }
    return operationToMethodMap;
  }

  private static Method findFinalResultMethod(Class<?> clazz) throws NoSuchMethodException {
    Method[] methods = clazz.getDeclaredMethods();
    return Arrays.stream(methods)
        .filter(method -> method.isAnnotationPresent(Annotations.FinalResult.class)).findFirst()
        .orElseThrow(() -> new RuntimeException("No method found with FinalResult annotation"));
  }

  private static Map<String, Field> getInputToField(Class<?> clazz)
      throws IllegalAccessException {

      Field[] fields = clazz.getDeclaredFields();

//    Map<String, Field> inputToField = new HashMap<>();

//    for (Field field : fields) {
//      if(field.isAnnotationPresent(Input.class)) {
//          Input inputName = field.getAnnotation(Input.class);
//          inputToField.put(inputName.value(), field);
//      }
//    }

    return Stream.of(fields).filter(field -> field.isAnnotationPresent(Input.class))
        .collect(Collectors.toMap(field -> field.getAnnotation(Input.class).value(), Function.identity()));

  }
}
