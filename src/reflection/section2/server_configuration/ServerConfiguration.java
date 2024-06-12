package reflection.section2.server_configuration;

import java.net.InetSocketAddress;

public class ServerConfiguration {
    private final InetSocketAddress serverAddress;
    private final String greetingMessage;
    private static ServerConfiguration serverConfigurationInstance;
    private ServerConfiguration(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if(serverConfigurationInstance == null) {
            serverConfigurationInstance = this;
        }
    }
    public static ServerConfiguration getInstance() {
        return serverConfigurationInstance;
    }
    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }
    public String getGreetingMessage() {
        return greetingMessage;
    }
}
