package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JSpinner alpha;
    private CardLayout poker;

    private JTextField decrypt;

    private JTextField encrypt;

    private JComboBox<String> cb;

    private JTextField ein;

    private Controller controller;

    private JPanel change;

    private JButton submitEncrypt;

    private JButton submitDecrypt;

    public GUI () {
        this.setLayout(new GridLayout(5,2,10,10));
        this.add(new JTextArea("Was verschlüsselt werden soll"));
        this.encrypt = new JTextField();
        this.add(this.encrypt);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new JTextArea("Text zum Entschlüsseln"));
        this.decrypt = new JTextField();
        this.add(decrypt);
        this.add(new JTextArea("Welche Art der Verschlüsselung"));
        String[] choices = {"Ceasar Verschlüsselung","Substitution Cipher"};
        this.cb = new JComboBox<String>(choices);
        this.cb.addActionListener(e -> controller.selectorListener());
        this.add(this.cb);
        SpinnerModel model = new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
        this.alpha = new JSpinner(model);
        this.add(new JTextArea("Offset"));
        this.change = new JPanel();
        this.poker = new CardLayout();
        this.change.setLayout(this.poker);
        this.change.add(this.alpha);
        this.add(this.change);
        this.ein = new JTextField();
        this.change.add(this.ein);
        this.poker.next(this.change);
        this.poker.next(this.change);
        this.submitEncrypt = new JButton("Verschlüsseln");
        this.submitDecrypt = new JButton("Entschlüsseln");
        this.submitEncrypt.addActionListener(e -> controller.encryptListener());
        this.submitDecrypt.addActionListener(e -> controller.decryptListener());
        this.add(submitDecrypt);
        this.add(submitEncrypt);
        this.setVisible(true);
    }

    public void next(){
        this.poker.next(this.change);
    }

    public JTextField getDecrypt() {
        return decrypt;
    }

    public void setDecrypt(JTextField decrypt) {
        this.decrypt = decrypt;
    }

    public JTextField getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(JTextField encrypt) {
        this.encrypt = encrypt;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JSpinner getAlpha() {
        return alpha;
    }

    public void setAlpha(JSpinner alpha) {
        this.alpha = alpha;
    }

    public JPanel getChange() {
        return change;
    }

    public void setChange(JPanel change) {
        this.change = change;
    }

    public CardLayout getPoker() {
        return poker;
    }

    public void setPoker(CardLayout poker) {
        this.poker = poker;
    }

    public JComboBox<String> getCb() {
        return cb;
    }

    public void setCb(JComboBox<String> cb) {
        this.cb = cb;
    }

    public JTextField getEin() {
        return ein;
    }

    public void setEin(JTextField ein) {
        this.ein = ein;
    }
}
