package figuren.model;

import java.awt.*;

public class Kreis extends Figur{
    private int radius;

    public Kreis(int x, int y, int radius, Color farbe){
        this.setX(x);
        this.setY(x);
        this.setFarbe(farbe);
        this.setRadius(radius);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(this.getFarbe());
        g.fillOval(this.getX(),this.getY(),radius,radius);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString(){
        return "("+this.getX() + "/" + this.getY()+") R:" + this.getRadius() + " Farbe: " + Integer.toHexString(this.getFarbe().getRGB());
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
