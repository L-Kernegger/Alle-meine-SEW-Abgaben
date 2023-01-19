package figuren.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import figuren.model.*;
import figuren.view.*;

import javax.swing.*;

/**
 * Ablaufsteuerung für das Rechteck-Zeichen-Beispiel
 * @author Lisa Vittori
 * @version 2019-11-25
 */
public class FigurController implements ActionListener {
  private FigurPanel fp;
  private FigurenListe fl;
  
  /**
   * Erzeugt die Objekte für View und Model
   */
  public FigurController() {
    fl = new FigurenListe();
    fp = new FigurPanel(fl, this);
    new FigurFrame("Figuren", fp, 1000, 700);
    
  }

  public void dropDownListener(){
    String x = fp.getCbArt().getSelectedItem().toString();
    switch (x){
      case ("Rechteck"):
        JLabel[] f = fp.getlWerte();
        f[2].setText("Breite");
        f[3].setText("Höhe");
        fp.setlWerte(f);
        JTextField[] h = fp.getTfWerte();
        h[3].setEditable(true);
        fp.setTfWerte(h);
        break;
      case ("Dreieck"):
        JLabel[] k = fp.getlWerte();
        k[2].setText("Breite");
        k[3].setText("Höhe");
        fp.setlWerte(k);
        JTextField[] t = fp.getTfWerte();
        t[3].setEditable(true);
        fp.setTfWerte(t);
        break;
      case ("Kreis"):
        JLabel[] j = fp.getlWerte();
        j[2].setText("Radius");
        j[3].setText("");
        fp.setlWerte(j);
        JTextField[] z = fp.getTfWerte();
        z[3].setEditable(false);
        fp.setTfWerte(z);
        break;
      case ("Linie"):
        JLabel[] d = fp.getlWerte();
        d[2].setText("X2");
        d[3].setText("Y2");
        fp.setlWerte(d);
        JTextField[] o = fp.getTfWerte();
        o[3].setEditable(true);
        fp.setTfWerte(o);
        break;
    }

  }

  /**
   * Ereignissteuerung für die Buttons "Hinzufügen" und "Zurücksetzen"
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String ac = e.getActionCommand();
    switch(ac) {
    case "add":
      String x = fp.getCbArt().getSelectedItem().toString();
      switch (x) {
        case "Rechteck":
          int x1 = fp.getXEingabe();
          int y1 = fp.getYEingabe();
          int b1 = fp.getBreite();
          int h1 = fp.getHoehe();
          if (x1 >= 0 && y1 >= 0 && b1 >= 0 && h1 >= 0) {
            Rechteck r = new Rechteck(x1, y1, b1, h1, fp.getFarbe());
            fl.addFigur(r);
            fp.eintragHinzufuegen(fl.letzeFigur());
            fp.repaint();
          }
          break;
        case "Dreieck":
          int x6 = fp.getXEingabe();
          int y6 = fp.getYEingabe();
          int b6 = fp.getBreite();
          int h6 = fp.getHoehe();
          if (x6 >= 0 && y6 >= 0 && b6 >= 0 && h6 >= 0) {
            Dreieck d = new Dreieck(x6, y6, b6, h6, fp.getFarbe());
            fl.addFigur(d);
            fp.eintragHinzufuegen(fl.letzeFigur());
            fp.repaint();
          }
          break;

        case "Kreis":
          int x2 = fp.getXEingabe();
          int y2 = fp.getYEingabe();
          int r = fp.getBreite();
          if (x2 >= 0 && y2 >= 0 && r >= 0) {
            Kreis kr = new Kreis(x2, y2, r, fp.getFarbe());
            fl.addFigur(kr);
            fp.eintragHinzufuegen(fl.letzeFigur());
            fp.repaint();
          }
          break;
        case "Linie":
          int x3 = fp.getXEingabe();
          int y3 = fp.getYEingabe();
          int x4 = fp.getBreite();
          int y4 = fp.getHoehe();
          if (x3 >= 0 && y3 >= 0 && y4 >= 0 && y4 >= 0) {
            Linie l = new Linie(x3, y3, x4, y4, fp.getFarbe());
            fl.addFigur(l);
            fp.eintragHinzufuegen(fl.letzeFigur());
            fp.repaint();
          }
          break;

      }
      break;
      case "clear":
        fl.clear();
        fp.clear();
        fp.repaint();
    }   
  }
  
  /**
   * Startet das Rechteck-Zeichenprogramm
   * @param args nicht verwendet
   */
  public static void main(String[] args) {
    new FigurController();
  }

}
