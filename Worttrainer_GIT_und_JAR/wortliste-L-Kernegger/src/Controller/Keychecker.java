package Controller;
import java.awt.event.*;


public class Keychecker extends KeyAdapter {

    Controller controller;

    public Keychecker(Controller controller){
        this.controller = controller;
    }

    
    /** 
     * @param event
     */
    public void keyPressed(KeyEvent event) {

        if(event.getKeyCode() == KeyEvent.VK_ENTER) {
            if(controller.getText() != null && controller.checkAnswer(controller.getText().getText())){
                controller.setWoerterRichtig(controller.getWoerterRichtig() + 1);
            }
            controller.setWoerterAnzahl(controller.getWoerterAnzahl() + 1);
            controller.zufall();
            controller.refresh();
            
        }
    }

}