package Test;

import javax.swing.*;
import java.awt.*;


public class GUI_test extends JFrame{
    public GUI_test(){
        GUI_Test_Panel test =  new GUI_Test_Panel();
        this.add(test);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_test();
    }
    
}
