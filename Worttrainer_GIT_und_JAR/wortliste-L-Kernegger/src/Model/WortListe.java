package Model;

/**
 * eine ArrayKlasse für WortEintrag
 * @author Kernegger Leopold
 * @version 29.9.22
 */

public class WortListe {
    private WortEintrag[] eintraege;
    private int anzahlEintraege;

    /**
     * constructor
     * @param länge länge des Arrays
     */
    public WortListe (int laenge) {
        if(laenge > 0){
            this.eintraege = new WortEintrag[laenge];
            this.anzahlEintraege = this.eintraege.length;
        }
        
    }

    /**
     * constructor
     * @param länge länge des Arrays
     */
    public WortListe (WortEintrag[] liste) throws NullPointerException{
        if(liste != null){
            this.eintraege = liste;
            this.anzahlEintraege = this.eintraege.length;
        } else{
            throw new NullPointerException();
        }
    }

    /**
     * 
     * @param eintrag hinzuzufügender Beitrag
     * @return Erfolg
     */
    public boolean addEintrag(WortEintrag eintrag) {
        if(this.eintraege != null){
            int p = -1;
            for (int i = 0; i < this.eintraege.length; i++) {
                if (this.eintraege[i] == null) {
                    p = i;
                }
            }
            if (p >= 0) {
                this.eintraege[p] = eintrag;
                this.anzahlEintraege = this.eintraege.length;
                return true;
            }
            WortEintrag[] temp = new WortEintrag[this.eintraege.length + 1];
            for (int i = 0; i < this.eintraege.length; i++) {
                temp[i] = this.eintraege[i];
            }
            if (temp[temp.length - 1] == null) {
                temp[temp.length - 1] = eintrag;
                this.eintraege = temp;
                this.anzahlEintraege = this.eintraege.length;
                return true;
            }
            return false;
        }else{
            WortEintrag[] temp = new WortEintrag[1];
            for (int i = 0; i < 1; i++) {
                temp[i] = this.eintraege[i];
            }
            if (temp[temp.length - 1] == null) {
                temp[temp.length - 1] = eintrag;
                this.eintraege = temp;
                this.anzahlEintraege = this.eintraege.length;
                return true;
            }
            return false;
        }
        
    }
    /**
     * ein getter
     * @param index der Index
     * @return das Objekt
     */
    public WortEintrag getEintraege(int index) {
        return this.eintraege[index];
    }
    /**
     * ein getter
     * @return das Array
     */
    public WortEintrag[] getEintraege() {
        return this.eintraege;
    }
    /**
     * ein setter
     * @param eintraege der zu settenden
     * @param index index des geseteten
     */
    public void setEintraege(WortEintrag eintraege, int index) throws NullPointerException{
        if(this.eintraege != null){
            this.eintraege[index] = eintraege;
            this.anzahlEintraege = this.eintraege.length;
        }else{
            throw new NullPointerException();
        }
    }
    /**
     * löscht einen Eintrag und verkleinert das Array
     * @param Wort das zu löschende Wort
     * @return erfolgreich?
     */
    public boolean deleteEintraege(String Wort) throws NullPointerException{
        if(this.eintraege != null){
            int x = 0;
            int p = this.eintraege.length;
            for (int i = 0; i < this.eintraege.length; i++) {
                if (this.eintraege[i].getWort().equals(Wort)) {
                   this.eintraege[i] = null;
                   x++;
                }
            }
            int j = 0;
            WortEintrag[] neW = new WortEintrag[this.eintraege.length-x]; 
            for (int i = 0; i < this.eintraege.length; i++) {
                if (this.eintraege[i] != null) {
                    neW[j] = this.eintraege[i];
                    j++;
                }   
            }   
            this.eintraege = neW;
            this.anzahlEintraege = this.eintraege.length;
            if(this.eintraege.length >= p){
                return false;
            }
            return true;
        }else{
            throw new NullPointerException();
        }
    }
    /**
     * um das Objekt besser darzustellen
     */
    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i < this.eintraege.length; i++) {
            if(this.eintraege[i] != null){
                x =  x + this.eintraege[i].toString() + "\n";
            }
        }
        x = x + "Es sind insgesamt " + this.anzahlEintraege + " Einträge vorhanden.";  
        return x;
    }

    public void assertionTest(){
        System.out.println(this.anzahlEintraege == this.eintraege.length);
        assert this.anzahlEintraege == this.eintraege.length : " Test Methode";
    }
}
