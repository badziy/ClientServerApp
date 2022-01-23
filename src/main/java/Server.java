import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("server started");
        int port = 8080;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("New connection accepted");

                out.println("Введите имя");
                final String username = in.readLine();
                out.println("Вы ощущаете себя ребёнком (да/нет)");
                final String answer = in.readLine();
                if (answer.equals("да")) {
                    out.println(String.format("Добро пожаловать в детскую зону, %s! Давай играть!", username));
                } else if (answer.equals("нет")) {
                    out.println(String.format("Добро пожаловать в взрослую зону, %s! Хорошего отдыха или плодотворного рабочего дня!", username));
                } else {
                    out.println("Ошибка");
                }
            } catch (IOException e) {
                System.out.println("Соединение разорвано");
            }
        }
    }
}
