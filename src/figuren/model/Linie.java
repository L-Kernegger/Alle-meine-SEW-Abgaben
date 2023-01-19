package figuren.model;

import java.awt.*;

public class Linie extends Figur {
    private int x2;
    private int y2;

    public Linie(int x,int y,int x2, int y2, Color color) {
        this.setX(x);
        this.setY(y);
        this.setFarbe(color);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(this.getFarbe());
        g.drawLine(this.getX(),this.getY(), this.getX2(), this.getY2());
    }

    @Override
    public String toString(){
        return "("+this.getX() + "/" + this.getY()+")"+" ("+this.getX2() + "/" + this.getY2()+")"+ " Farbe: "+ Integer.toHexString(this.getFarbe().getRGB());
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
