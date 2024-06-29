package reflection.section7.repeatable_annotations.exercise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations {

  @Repeatable(PermissionManager.class)
  @Target(ElementType.TYPE)
  public @interface Permissions {
    Role role();
    OperationType[] allowed();
  }

  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  public @interface PermissionManager {
    Permissions[] value();
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  public @interface MethodOperations {
    OperationType[] value();
  }
}
