package java_eight.assignments.assignment1;

@FunctionalInterface
public interface Evaluate<T> {
  Boolean isNegative(T t);
}
