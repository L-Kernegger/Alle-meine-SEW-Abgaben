import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Lagerhalle {
    private String strasse;
    private int hausnummer;
    private int plz;
    private String staat;
    private UUID id;
    private HashMap<Gegenstand, Integer> bestand;

    public Lagerhalle() {
        this.bestand = new HashMap<>();
    }

    public Lagerhalle(String strasse, int hausnummer, String staat, int plz) {
        this.bestand = new HashMap<>();
        this.setId();
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.staat = staat;
        this.plz = plz;
    }

    public String bestandDesLagers(){
        String r = "";
        int c  = 0;
        for (Gegenstand x:
             bestand.keySet()) {
            r = r+ x.getName().charAt(0) + " (" +x.getName() + "): " + this.bestand.get(x) + "; ";
        }
        return r;
    }

    public int bestandAnzahlGegenstands(Gegenstand g){
        return this.bestand.get(g);
    }

    public void bestandHinzu(Gegenstand g , int m) {
        if(this.bestand.containsKey(g)) {
            int t = this.bestand.get(g);
            this.bestand.put(g, t + m);
        }
        else {
            this.bestand.put(g,m);
        }
    }

    public void bestandWeg(Gegenstand g){
        this.bestand.remove(g);
    }

    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public int getHausnummer() {
        return hausnummer;
    }
    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }
    public int getPlz() {
        return plz;
    }
    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStaat() {
        return staat;
    }

    public void setStaat(String staat) {
        this.staat = staat;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = new UUID(64,8);
    }

    public HashMap<Gegenstand, Integer> getBestand() {
        return bestand;
    }

    public void setBestand(HashMap<Gegenstand, Integer> bestand) {
        this.bestand = bestand;
    }
}
