package chat;

import java.io.DataInputStream;
import java.io.IOException;

public class ThreadClient extends Thread{

    FenetreClient fc;
    DataInputStream is;

    public ThreadClient(FenetreClient fc, DataInputStream is) {
        this.fc = fc;
        this.is = is;

        start();
    }

    @Override
    public void run() {
        String message;
        
        while (true) {
            try {
                //Ecoute de nouveau message
                message = is.readUTF();

                //Ajout du message au Text area du fenetre
                fc.getAllMessage().setText(fc.getAllMessage().getText()+"\n"+message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
