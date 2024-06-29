package reflection.section7.repeatable_annotations.loaders;

import static reflection.section7.repeatable_annotations.annotations.Annotations.*;

@ScheduledExecutorClass
public class Cache {
    @ExecuteOnSchedule(periodSeconds = 5)
    @ExecuteOnSchedule(periodSeconds = 1, delaySeconds = 10)
    public static void reloadCache() {
        System.out.println("Reloading cache");
    }
}
