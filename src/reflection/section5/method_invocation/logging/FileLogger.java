package reflection.section5.method_invocation.logging;

import java.io.IOException;

public class FileLogger {
    public void sendRequest(String data) throws IOException {
        throw new IOException("Failed to save data to file system");
//        System.out.println(String.format("Data %s is successfully logged to file system", data));
    }
}
