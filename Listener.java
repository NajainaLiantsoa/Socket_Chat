package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Listener implements ActionListener {

    FenetreClient fenetreClient;

    public Listener(FenetreClient fc) {
        fenetreClient = fc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //On click send message
            fenetreClient.sendMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
