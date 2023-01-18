package View;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.net.MalformedURLException;



public class Worttrainer_GUI extends JFrame{



    private JPanel top;
    private JPanel bottom;
    private JPanel maxwell;
    private JPanel superBottom;
    private JLabel image;

    private JPanel frameObj;
    private Controller controller;
    private JTextField text;

    private JLabel woerterAnzahl;
    private JLabel woerterRichtig;

    

/**
 * @param usedController
 * @throws IOException
 * @throws MalformedInputException
 * @throws MalformedURLException
 */
public Worttrainer_GUI(Controller usedController) throws IOException,MalformedInputException,MalformedURLException{
    controller = usedController;

    controller.setWoerterAnzahl(0);
    controller.setWoerterRichtig(0);

    this.superBottom = new JPanel();
    this.superBottom.setLayout(new GridLayout(1,2));
    JButton save = new JButton("Laden");
    save.addActionListener(e -> controller.buttonLoad());
    
    JButton load = new JButton("Speichern");
    load.addActionListener(e -> controller.buttonSave());
    
    superBottom.add(save);
    superBottom.add(load);
    superBottom.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));


    frameObj = new JPanel();

    this.top = new JPanel();
    this.bottom = new JPanel();
    this.maxwell = new JPanel();

    frameObj.setLayout(new BoxLayout(frameObj, BoxLayout.Y_AXIS));

    frameObj.add(top);
    frameObj.add(maxwell);
    frameObj.add(bottom);
    frameObj.add(superBottom);

    
    
    top.setLayout(new GridLayout(2,1));
    maxwell.setLayout(new BoxLayout(this.maxwell, BoxLayout.Y_AXIS));
    bottom.setLayout(new GridLayout(2,3));

    top.add(new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?"));
    text = new JTextField();
    text.setMaximumSize(new Dimension(100,30));
    text.addKeyListener(new Keychecker(controller));
    top.add(text);
    Dimension test = new Dimension(1000, 400);
    ImageIcon imageIcon = new ImageIcon(controller.readImage());
    this.image = new JLabel();
    this.image.setIcon(imageIcon);
    this.image.setMaximumSize(test);;
    maxwell.add(this.image);

    int ratio =  1;
    int width = imageIcon.getIconWidth();
    int height = imageIcon.getIconWidth() ;
    /** 
    if(imageIcon.getIconWidth()  > 500 || imageIcon.getIconWidth() > 500){
        if (imageIcon.getIconWidth() < imageIcon.getIconWidth()) {
            ratio =  imageIcon.getIconHeight() / imageIcon.getIconWidth();
            height = ratio * imageIcon.getIconWidth();
            width = 500;
        } else if(imageIcon.getIconWidth() > imageIcon.getIconWidth()) {
            ratio =  imageIcon.getIconWidth() / imageIcon.getIconHeight();
            width = ratio * imageIcon.getIconHeight();
            height = 500;
        } else {
            width = 500;
            height = 500;
        }
    }
*/

    maxwell.setSize(test);

    bottom.add(new JLabel("Richtige Wörter:"));
    this.woerterRichtig= new JLabel(String.valueOf(controller.getWoerterRichtig()));
    bottom.add(this.woerterRichtig);
    JButton reset= new JButton("Zurücksetzen");
    reset.addActionListener(e -> {
        try {
            controller.resetListener();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    });
    bottom.add(reset);
    bottom.add(new JLabel("Anzahl Wörter:"));
    this.woerterAnzahl = new JLabel(String.valueOf(controller.getWoerterAnzahl()));
    bottom.add(woerterAnzahl);
    JButton input = new JButton("Wort hinzufügen");
    input.addActionListener(e -> controller.newEntry());
    bottom.add(input);

    this.add(frameObj);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(300,600);
    this.setTitle("Der große Worttrainer");
    this.setVisible(true);

}








/** 
 * @return JPanel
 */
public JPanel getFrameObj() {
    return frameObj;
}


/** 
 * @param frameObj
 */
public void setFrameObj(JPanel frameObj) {
    this.frameObj = frameObj;
}




/** 
 * @return Controller
 */
public Controller getController() {
    return controller;
}




/** 
 * @param controller
 * @throws NullPointerException
 */
public void setController(Controller controller) throws NullPointerException{
    if (controller != null) {
        this.controller = controller;
    }else{
        throw new NullPointerException("Controller can not be null");
    }
}





/** 
 * @return JTextField
 */
public JTextField getText() {
    return text;
}


/** 
 * @param text
 */
public void setText(JTextField text) {
    this.text = text;
}


/** 
 * @return JPanel
 */
public JPanel getTop() {
    return top;
}


/** 
 * @param top
 */
public void setTop(JPanel top) {
    this.top = top;
}


/** 
 * @return JPanel
 */
public JPanel getBottom() {
    return bottom;
}


/** 
 * @param bottom
 */
public void setBottom(JPanel bottom) {
    this.bottom = bottom;
}


/** 
 * @return JPanel
 */
public JPanel getMaxwell() {
    return maxwell;
}


/** 
 * @param maxwell
 */
public void setMaxwell(JPanel maxwell) {
    this.maxwell = maxwell;
}



/** 
 * @return JLabel
 */
public JLabel getWoerterRichtig() {
    return woerterRichtig;
}



/** 
 * @param woerterRichtig
 */
public void setWoerterRichtig(JLabel woerterRichtig) {
    this.woerterRichtig = woerterRichtig;
}


/** 
 * @param toSet
 */
public void setWoerterRichtigText(String toSet) {
    this.woerterRichtig.setText(toSet);
}



/** 
 * @return JLabel
 */
public JLabel getImage() {
    return image;
}


/** 
 * @param image
 */
public void setImage(JLabel image) {
    this.image = image;
}

/** 
 * @param image
 */
public void setImage(Image image) {
    ImageIcon imageIcon = new ImageIcon(image);
    this.image.setIcon(imageIcon);
}


/** 
 * @return JLabel
 */
public JLabel getWoerterAnzahl() {
    return woerterAnzahl;
}


/** 
 * @param toSet
 */
public void setWoerterAnzahlText(String toSet) {
    this.woerterAnzahl.setText(toSet);
}








/** 
 * @return JPanel
 */
public JPanel getSuperBottom() {
    return superBottom;
}








/** 
 * @param superBottom
 */
public void setSuperBottom(JPanel superBottom) {
    this.superBottom = superBottom;
}








/** 
 * @param woerterAnzahl
 */
public void setWoerterAnzahl(JLabel woerterAnzahl) {
    this.woerterAnzahl = woerterAnzahl;
}
}
