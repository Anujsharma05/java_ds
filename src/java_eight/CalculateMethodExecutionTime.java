package java_eight;

import java.time.Duration;
import java.time.Instant;

public class CalculateMethodExecutionTime {
    public static void main(String[] args) throws InterruptedException {
        testMethod();
    }
    static void testMethod() throws InterruptedException {

        /**
         * Start time
         */
        Instant startTime = Instant.now();
        System.out.println("start");
            Thread.sleep(2000);
        System.out.println("end");
        Instant endTime = Instant.now();

        Duration duration = Duration.between(startTime, endTime);

        System.out.println("duration: " + duration);
    }
}
