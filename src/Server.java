import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private final Page page;

    public Server(int port, Page page) {
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("Geçersiz port: " + port);
        }
        this.port = port;
        this.page = page;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Sunucu " + port + " portunda çalışıyor...");

        while (true) {
            Socket client = serverSocket.accept();
            RequestHandler handler = new RequestHandler(client, page);
            handler.handle();
        }
    }
}