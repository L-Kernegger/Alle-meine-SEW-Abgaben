package Model;

/**
 * Diese Klasse ist da, um Testfunktionalität zu der Klasse WortListe hinzuzufügen.
 * @author Kernegger Leopold
 * @version 29.9.22
 */
public class WortTrainer {
    private WortListe traingingsListe;
    private WortEintrag ausgewaehlt;
    int woerterAnzahl = 0;
    int woerterRichtig = 0;

    public void assertionTest(){
        traingingsListe.assertionTest();
    }

    /**
     * setet ausgewaehlt auf einen zufälligen Eintrag
     */
    public void zufall() {
        WortEintrag[] y = traingingsListe.getEintraege();
        double x = Math.random();
        x = x * y.length;
        int index = (int) x;
        this.ausgewaehlt = traingingsListe.getEintraege(index);
    }

    
    /** 
     * @param newEntry
     * @return boolean
     */
    public boolean addNewEntry(WortEintrag newEntry){
        return this.traingingsListe.addEintrag(newEntry);
    }

    /**
     * ein getter
     * @return die Liste
     */
    public WortListe getTraingingsListe() {
        return traingingsListe;
    }

    /**
     * ein getter
     * @return
     */
    public WortEintrag wort(){
        return ausgewaehlt;
    }
    /**
     * checkt den String mit einem anderen String
     * @param check der gegen den man checkt
     * @return true oder false
     */
    public boolean check(String check){
        return this.ausgewaehlt.getWort().equals(check);
    }
    /**
     * ignoriert die Groß- und Kleinschreibung beim checken
     * @param check gegen den es checken muss
     * @return wahr oder falsch
     */
    public boolean checkIgnoreCase(String check){
        return this.ausgewaehlt.getWort().equalsIgnoreCase(check);
    }
    /**
     * constructor
     * @param liste die Liste
     */
    public WortTrainer(WortListe liste) throws NullPointerException{
        if(liste != null){
            this.traingingsListe = liste;
            this.ausgewaehlt = null;
        }else{
            throw new NullPointerException();
        }
        
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String t = "";
        if(this.ausgewaehlt != null){
            t = ausgewaehlt.toString();
        }
        return this.traingingsListe.toString() + "\n" + t;
    }

    
    /** 
     * @param traingingsListe
     */
    public void setTraingingsListe(WortListe traingingsListe) {
        this.traingingsListe = traingingsListe;
    }

    
    /** 
     * @return WortEintrag
     */
    public WortEintrag getAusgewaehlt() {
        return ausgewaehlt;
    }

    
    /** 
     * @param ausgewaehlt
     */
    public void setAusgewaehlt(WortEintrag ausgewaehlt) {
        this.ausgewaehlt = ausgewaehlt;
    }

    
    /** 
     * @return int
     */
    public int getWoerterAnzahl() {
        return woerterAnzahl;
    }

    
    /** 
     * @param woerterAnzahl
     */
    public void setWoerterAnzahl(int woerterAnzahl) {
        this.woerterAnzahl = woerterAnzahl;
    }

    
    /** 
     * @return int
     */
    public int getWoerterRichtig() {
        return woerterRichtig;
    }

    
    /** 
     * @param woerterRichtig
     */
    public void setWoerterRichtig(int woerterRichtig) {
        this.woerterRichtig = woerterRichtig;
    }

}
