package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {

    private GUI gui;
    private int counter;

    private int index;

    private MonoAlphabeticCipher cipher;

    public Controller(GUI gui, int counter, int index) {
        this.gui = gui;
        gui.setController(this);
        this.counter = counter;
        this.index = index;
    }

    public Controller() {
        this.gui = new GUI();
        gui.setController(this);
        this.counter = 0;
        this.index = 0;
    }

    public void selectorListener(){
            gui.next();

    }

    public void encryptListener(){
        String x = gui.getEncrypt().getText();
        String p = gui.getCb().getSelectedItem().toString();
        if (p.equals("Ceasar Verschlüsselung")){
            int i = (Integer) gui.getAlpha().getValue();
            ShiftCipher shift = new ShiftCipher(i);
            this.cipher = shift;
            String z = this.cipher.encrypt(x);
            JOptionPane.showMessageDialog(new JFrame(), "Verschlüsselt wäre dass: \n" + z);
        }else {
            String i = gui.getEin().getText();
            SubstitutionCipher subst = new SubstitutionCipher(i);
            this.cipher = subst;
            String z = this.cipher.encrypt(x);
            JOptionPane.showMessageDialog(new JFrame(), "Verschlüsselt wäre dass: \n" + z);
        }
    }


    public void decryptListener (){
        String x = gui.getDecrypt().getText();
        String p = gui.getCb().getSelectedItem().toString();
        if (p.equals("Ceasar Verschlüsselung")){
            int i = (Integer) gui.getAlpha().getValue();
            ShiftCipher shift = new ShiftCipher(i);
            this.cipher = shift;
            String z = this.cipher.decrypt(x);
            JOptionPane.showMessageDialog(new JFrame(), "Entschlüsselt wäre dass: \n" + z);
        }else {
            String i = gui.getEin().getText();
            SubstitutionCipher subst = new SubstitutionCipher(i);
            this.cipher = subst;
            String z = this.cipher.decrypt(x);
            JOptionPane.showMessageDialog(new JFrame(), "Entschlüsselt wäre dass: \n" + z);
        }
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

}
