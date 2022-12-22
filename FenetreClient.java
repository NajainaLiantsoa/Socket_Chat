package chat;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;

public class FenetreClient extends JFrame{
    private final JTextField input = new JTextField();
    private final JButton send = new JButton("Envoyer");
    private final JScrollPane scrollPane = new JScrollPane();
    private final JTextArea allMessage = new JTextArea();

    private DataOutputStream os;


    public FenetreClient(String title, DataOutputStream os) {
        initFrame(title);
        this.os = os;

        Listener listener = new Listener(this);
        //Ajout de listener au boutton send
        send.addActionListener(listener);
    }

    public void initFrame(String title) {
        setTitle(title);
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);

        allMessage.setEditable(false);

        scrollPane.setBounds(50,25,400,350);
        scrollPane.setViewportView(allMessage);
        add(scrollPane);

        input.setBounds(50,390,300,50);
        send.setBounds(360,390,100,50);

        add(input);
        add(send);
        setVisible(true);
    }

    public void sendMessage() throws IOException {
        String message = input.getText();
        os.writeUTF(message);
        os.flush();
        input.setText("");
    }

    public JTextArea getAllMessage() {
        return allMessage;
    }
}
