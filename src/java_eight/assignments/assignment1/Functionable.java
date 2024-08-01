package java_eight.assignments.assignment1;

@FunctionalInterface
public interface Functionable<T, R> {
  R applyThis(T t);
}
