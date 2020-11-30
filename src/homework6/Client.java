package homework6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final String IP_ADDRESS = "localhost";
    static final int PORT = Server.PORT;

    public static void main(String[] args) {

        Socket socket = null;
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("You are connected");

            Thread clientReader = new Thread(() -> {
                try {
                    while (true) {
                        out.writeUTF(sc.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            clientReader.setDaemon(true);
            clientReader.start();

            clientPrintMessage(in,out);

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

    private static void clientPrintMessage(DataInputStream in, DataOutputStream out) {
        try {
            while (true) {
                String str = in.readUTF();
                if (str.equals("/quit")) {
                    System.out.println("User left server");
                    out.writeUTF("/quit");
                    break;
                } else {
                    System.out.println("Server: " + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
