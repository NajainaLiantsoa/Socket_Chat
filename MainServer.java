package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer {
    public static List<Client> clients = new ArrayList<>();
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            Socket socket;
            DataInputStream is;
            String nom;
            Client c;
            System.out.println("En attente d'utilisateur ");
            while (true) {
                //Accepte connection client
                socket = server.accept();

                //Creation de l'object client
                is = new DataInputStream(socket.getInputStream());
                //LEcture du nom du client
                nom = is.readUTF();

                
                c = new Client();
                c.setNom(nom);
                c.setIs(is);
                c.setOs(new DataOutputStream(socket.getOutputStream()));

                //ajout du nouveau client au liste de toute les clinets
                clients.add(c);

                //Lancement du ThreadA l'ecoute de client C au constructeur
                new ThreadServer(c);
            }
        }catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
