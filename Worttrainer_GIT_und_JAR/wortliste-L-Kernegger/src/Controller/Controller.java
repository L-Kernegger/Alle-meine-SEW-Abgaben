package Controller;
import View.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class Controller {
    

    WortTrainer trainer;
    Worttrainer_GUI gui;


    public Controller(String saved) throws IOException{
        trainer = Save_Worttrainer.load(saved);
        trainer.zufall();
        gui = new Worttrainer_GUI(this);
        gui.setController(this);
    }

    public void repaint(){
        this.gui.invalidate();
        this.gui.revalidate();
        this.gui.repaint();
    }

    
    /** 
     * @return Image
     * @throws IOException
     */
    public Image readImage() throws IOException{
        File file = new File(this.getWort() +".jpg");
        if (file.exists()) {
            BufferedImage bufferedImage = ImageIO.read(file);
            //Image temp = bufferedImage.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);
            Image temp = bufferedImage.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
            return temp;
        }
        if(WortEintrag.checkURL(this.getImage())){
            saveImage(this.getImage(), this.getWort()+".jpg");
            
            BufferedImage bufferedImage = ImageIO.read(file);
            Image temp = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            return temp;
        }
        return null;
    }

    public void buttonSave(){
        String name = JOptionPane.showInputDialog("Als was soll es gespeichert werden?") + ".SEW";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showOpenDialog(this.gui);
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath() +"\\" +name);
                File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath()+ "\\" +name);
                try {
                    Model.Save_Worttrainer.speichern(selectedFile,this.trainer);
                    JOptionPane.showMessageDialog(new JFrame(),"Succesfull");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(new JFrame(),"Error");
                }
            }
    }

    public void buttonLoad(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Glorreiche Files der Rafeiner Revolution","SEW");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(this.gui);
        if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    this.trainer = Model.Save_Worttrainer.load(selectedFile);
                    this.zufall();
                    this.refresh();
                    JOptionPane.showMessageDialog(new JFrame(),"Succesfull");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(new JFrame(),"Error");
                }
            }
    }

    
    /** 
     * @param answer
     * @return boolean
     */
    public boolean checkAnswer(String answer){
        return this.trainer.check(answer);
    }
    
    
    /** 
     * @param imageUrl
     * @param destinationFile
     * @throws IOException
     */
    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
    
        byte[] b = new byte[2048];
        int length;
    
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
    
        is.close();
        os.close();

    }

    
    /** 
     * @return String
     */
    public String getWort(){
        if (trainer.getAusgewaehlt().getWort() != null) {
            return trainer.getAusgewaehlt().getWort();
        }
        return "";
    }

    
    /** 
     * @return String
     */
    public String getImage(){
        return trainer.getAusgewaehlt().getUrl();
    }

    public void zufall(){
        if(trainer.getAusgewaehlt() == null){
            trainer.zufall();
        }
        String x = this.getWort();
        do {
            trainer.zufall();
        } while (this.getWort().equals(x));
        
    }

    
    /** 
     * @param newEntry
     * @return boolean
     * @throws IOException
     */
    public boolean addNewEntry(WortEintrag newEntry) throws IOException{
        boolean x =  trainer.addNewEntry(newEntry);
        Save_Worttrainer.speichern(trainer);
        return x;
    }

    
    /** 
     * @return int
     */
    public int getWoerterAnzahl() {
        return trainer.getWoerterAnzahl();
    }

    
    /** 
     * @param woerterAnzahl
     */
    public void setWoerterAnzahl(int woerterAnzahl) {
        trainer.setWoerterAnzahl(woerterAnzahl);
    }

    
    /** 
     * @return int
     */
    public int getWoerterRichtig() {
        return trainer.getWoerterRichtig();
    }

    
    /** 
     * @param woerterRichtig
     */
    public void setWoerterRichtig(int woerterRichtig) {
        trainer.setWoerterRichtig(woerterRichtig);
    }

    public void refresh(){
        gui.setWoerterAnzahlText(String.valueOf(this.getWoerterAnzahl()));
        gui.setWoerterRichtigText(String.valueOf(this.getWoerterRichtig()));
        try {
            gui.setImage(this.readImage());;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    

    
    /** 
     * @throws IOException
     */
    public void resetListener() throws IOException{


        gui.setController(this);

        this.setWoerterAnzahl(0);
        this.setWoerterRichtig(0);
        this.refresh();


        JPanel maxw = new JPanel();
        maxw.setLayout(new GridLayout(1,1));
        gui.setImage(gui.getController().readImage());
        gui.setWoerterAnzahlText("0");
        gui.setWoerterRichtigText("0");
        gui.repaint();
    }

    public void newEntry(){
        try{
            String name = JOptionPane.showInputDialog("gib den Namen des neuen Eintrags ein");
            String URL = JOptionPane.showInputDialog("gib die Url für das Bild des neuen Eintrags ein");
            this.addNewEntry(new WortEintrag(name, URL));
        }catch(Exception e){}
    }



    
    /** 
     * @return WortTrainer
     */
    public WortTrainer getTrainer() {
        return trainer;
    }

    
    /** 
     * @param trainer
     */
    public void setTrainer(WortTrainer trainer) {
        this.trainer = trainer;
    }

    
    /** 
     * @return Worttrainer_GUI
     */
    public Worttrainer_GUI getGui() {
        return gui;
    }

    
    /** 
     * @param gui
     */
    public void setGui(Worttrainer_GUI gui) {
        this.gui = gui;
    }

    
    /** 
     * @return JTextField
     */
    public JTextField getText() {
        return gui.getText();
    }

    
}
