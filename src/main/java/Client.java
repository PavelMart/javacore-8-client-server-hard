import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        try (Socket clientSocket = new Socket(host, Server.PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.println("Nikita");
            String resp = reader.readLine();
            System.out.println(resp);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
