package Test;

/**
 * GUI_Test_Panel
 */

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
public class GUI_Test_Panel extends JPanel{

    public GUI_Test_Panel(){
        super();
    }

    @Override
    public void paint(Graphics g) {  
        Dimension size = getSize();   
            int d = Math.min(size.width, size.height);    
            int x = (size.width - d)/2;    
            int y = (size.height - d)/2;       
        g.fillOval(x, y, d, d);     
            g.setColor(Color.black);   
            g.drawOval(x, y, d, d);
    }
}