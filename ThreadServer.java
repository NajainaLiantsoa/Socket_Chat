package chat;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.net.SocketException;


public class ThreadServer extends Thread{

    private final Client client;

    public ThreadServer(Client c) {
        client = c;

        start();
    }

    @Override
    public void run() {
        String message;
        String mess;
        String nom;
        try {

            while(true) {
                //Ecoute de nouveau message
                mess = client.getNom()": "+client.getIs().readUTF();
                
                //Manaparitaka message @client rehetra  message clients connected
                sendMessage(mess);
            } 
            

        }catch (IOException e) {

                MainServer.clients.remove(client);
            }
    }

    //Broad cast message
    private void sendMessage(String message) throws IOException {
        for (Client c : MainServer.clients) {
            c.getOs().writeUTF(message);
        }
    }
}

