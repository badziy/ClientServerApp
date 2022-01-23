import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Соединение с сервером установлено");

            String serverWord;
            for (int i = 0; i < 2; i++) {
                serverWord = in.readLine();
                System.out.println(serverWord);
                String answer = reader.readLine();
                out.write(answer + "\n");
                out.flush();
            }
            serverWord = in.readLine();
            System.out.println(serverWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
