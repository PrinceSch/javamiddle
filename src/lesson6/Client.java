package lesson6;

import java.io.*;
import java.net.Socket;

public class Client {

    static final String IP_ADDRESS = "localhost";
    static final int PORT = 8190;

    public static void main(String[] args) throws InterruptedException{
        try (Socket socket = new Socket(IP_ADDRESS,PORT);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
             DataInputStream ois = new DataInputStream(socket.getInputStream())){

            System.out.println("You were connected");

            while (!socket.isOutputShutdown()){
                if(br.ready()){
                    String clientCommand = br.readLine();
                    oos.writeUTF(clientCommand);
                    oos.flush();
                    if(clientCommand.equalsIgnoreCase("quit")){
                        System.out.println("Client kill connections");
                        break;
                    }
                    if(ois.read() > -1){
                        System.out.println(ois.readUTF());
                    }
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
