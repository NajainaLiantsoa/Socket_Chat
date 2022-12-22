package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Client {
    String nom;
    DataOutputStream os;
    DataInputStream is;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public DataOutputStream getOs() {
        return os;
    }

    public void setOs(DataOutputStream os) {
        this.os = os;
    }

    public DataInputStream getIs() {
        return is;
    }

    public void setIs(DataInputStream is) {
        this.is = is;
    }
}
