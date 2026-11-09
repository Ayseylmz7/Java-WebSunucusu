import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler {
    private final Socket client;
    private final Page page;

    public RequestHandler(Socket client, Page page) {
        this.client = client;
        this.page = page;
    }

    public void handle() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(
                new OutputStreamWriter(client.getOutputStream(), "UTF-8"));

        String line;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            System.out.println(line);
        }

        String html = page.build();

        out.print("HTTP/1.1 200 OK\r\n");
        out.print("Content-Type: text/html; charset=UTF-8\r\n");
        out.print("\r\n");
        out.print(html);
        out.flush();

        client.close();
    }
}