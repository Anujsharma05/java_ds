package reflection.section5.method_invocation.http;

public class HttpClient {
    private String serverAddress;
    public HttpClient(String serverAddress) {
        this.serverAddress = serverAddress;
    }
    public boolean sendRequest(String data) {
        System.out.println(String.format("Data %s successfully sent to server %s", data, serverAddress));
        return true;
    }
}
