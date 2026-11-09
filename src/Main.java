import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Page page = new HtmlPage();
        Server server = new Server(1989, page);
        server.start();
    }
}