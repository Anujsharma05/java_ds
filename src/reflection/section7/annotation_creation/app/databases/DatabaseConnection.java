package reflection.section7.annotation_creation.app.databases;

import reflection.section7.annotation_creation.annotations.InitializerClass;
import reflection.section7.annotation_creation.annotations.InitializerMethod;
import reflection.section7.annotation_creation.annotations.RetryOperation;

import java.io.IOException;

@InitializerClass
public class DatabaseConnection {

    private int failCounter = 5;

    @RetryOperation(
            numberOfRetries = 10,
            retryException = {IOException.class},
            durationBetweenRetries = 1000,
            failureMessage = "Connection to database 1 failed after retries"
    )
    @InitializerMethod
    public void connectToDatabase1() throws IOException {
        System.out.println("Connecting to database 1");

        if(failCounter > 0) {
            failCounter--;
            throw new IOException("Failed to connect");
        }
        System.out.println("Connection to database 1 succeeded");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }
}
