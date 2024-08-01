package reflection.section7.repeatable_annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations {

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface ScanPackages {
    String[] value();
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface ScheduledExecutorClass {

  }

  /**
   * No need to mention runtime here as it is
   * mentioned on annotation "ExecutionSchedules"
   * But @Target must be added to both of them
   */
  @Repeatable(ExecutionSchedules.class)
  @Target(ElementType.METHOD)
  public @interface ExecuteOnSchedule {
    int delaySeconds() default 0;
    int periodSeconds();
  }

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  public @interface ExecutionSchedules {
    ExecuteOnSchedule[] value();
  }

}
