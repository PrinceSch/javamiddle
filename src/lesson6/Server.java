package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int PORT = 8190;

    public static void main (String[] args) throws InterruptedException{
        try (ServerSocket server = new ServerSocket(PORT)){
            Socket client = server.accept();
            System.out.println("User connected");
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            while (!client.isClosed()){
                String entry = in.readUTF();
                System.out.println("user message: " + entry);
                if(entry.equalsIgnoreCase("quit")){
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - "+entry + " - OK");
                    out.flush();
                    break;
                }
                out.writeUTF("Server: "+ entry);
                out.flush();
            }
            in.close();
            out.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
