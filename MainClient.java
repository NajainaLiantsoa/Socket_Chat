package chat;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainClient {
    

    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog(null, "Ip serveur");
        String nom = JOptionPane.showInputDialog(null, "Votre nom");
        try {
            //Creation de l'objet socket connection

            Socket socket = new Socket(ip, 5000);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            //Envoie du nom
            os.writeUTF(nom);
            os.flush();

            //Oversture de la fenetre;
            FenetreClient fc = new FenetreClient(nom, os);

            //Lancement du thread a l'ecoute des message
            new ThreadClient(fc, is);
            

        }catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
