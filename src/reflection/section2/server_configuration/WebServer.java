package reflection.section2.server_configuration;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class WebServer {
    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(ServerConfiguration.getInstance().getServerAddress(), 0);

        httpServer.createContext("/greeting").setHandler(exchange -> {
            String responseMessage =
                    ServerConfiguration.getInstance().getGreetingMessage();

            exchange.sendResponseHeaders(200, responseMessage.length());

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        System.out.printf("Starting server on %s:%d%n", ServerConfiguration.getInstance().getServerAddress().getHostName(), ServerConfiguration.getInstance().getServerAddress().getPort());

        httpServer.start();
    }
}
