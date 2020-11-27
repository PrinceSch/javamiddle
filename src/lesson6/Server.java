package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int PORT = 8190;

    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server launched");


            try (Socket socket = serverSocket.accept();
                 DataInputStream in = new DataInputStream(socket.getInputStream())) {
                System.out.println("User connected");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                String str = in.readUTF();
                                if (str.equals("/end")) {
                                    System.out.println("User disconnected");
                                    break;
                                }
                                Client.clientPrintMessage(str, socket);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void serverPrintMessage(String msg, Socket socket) {

        try (DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        output.writeUTF("user message: " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}