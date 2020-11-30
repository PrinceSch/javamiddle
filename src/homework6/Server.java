package homework6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static final int PORT = 8190;

    public static void main(String[] args) {

        Socket socket = null;
        Scanner sc = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server launched");
            socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("User connected");

            Thread serverReader = new Thread(() -> {
                try {
                    while (true){
                        out.writeUTF(sc.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverReader.setDaemon(true);
            serverReader.start();

            serverPrintMessage(in,out);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }

    }

    private static void serverPrintMessage(DataInputStream in, DataOutputStream out) {
        try {
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
