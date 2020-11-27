package lesson6;

import java.io.*;
import java.net.Socket;

public class Client {

    static final String IP_ADDRESS = "localhost";
    static final int PORT = 8190;

    public static void main(String[] args) throws InterruptedException{

        try (Socket socket = new Socket(IP_ADDRESS,PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream())){
            System.out.println("You are connected");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                System.out.println("You were quit");
                                break;
                            }
                            Server.serverPrintMessage(str, socket);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void clientPrintMessage (String msg, Socket socket){
        try (DataOutputStream output = new DataOutputStream(socket.getOutputStream())){
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
