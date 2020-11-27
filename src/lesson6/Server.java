package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static int PORT = 8190;

    public static void main(String[] args) {

        Socket clientSocket = null;
        Scanner scanner = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server launched");
            clientSocket = serverSocket.accept();

            System.out.println("User connected " + clientSocket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            Thread serverReader = new Thread(() -> {
                try {
                    while (true){
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverReader.setDaemon(true);
            serverReader.start();

            while (true) {
                String str = in.readUTF();
                if (str.equals("/quit")) {
                    System.out.println("User left server");
                    out.writeUTF("/quit");
                    break;
                } else {
                    System.out.println("User: " + str);
                }

            }

            } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}