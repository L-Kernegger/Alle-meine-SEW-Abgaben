public class Main {
    public static void main(String[] args) {

        Gegenstand gegenstand1 = new Gegenstand("Artikel1", 10, Gegenstandstyp.TSS);
        Gegenstand gegenstand2 = new Gegenstand("Artikel2", 5, Gegenstandstyp.TSL);
        Gegenstand gegenstand3 = new Gegenstand("Artikel3", 8, Gegenstandstyp.TSM);
        System.out.println("Name von Artikel1: " + gegenstand1.getName());
        System.out.println("Gewicht von Artikel1: " + gegenstand1.getWeight());
        System.out.println("Typ von Artikel1: " + gegenstand1.getTyp());

        System.out.println("Name von Artikel2: " + gegenstand2.getName());
        System.out.println("Gewicht von Artikel2: " + gegenstand2.getWeight());
        System.out.println("Typ von Artikel2: " + gegenstand2.getTyp());

        System.out.println("Name von Artikel3: " + gegenstand3.getName());
        System.out.println("Gewicht von Artikel3: " + gegenstand3.getWeight());
        System.out.println("Typ von Artikel3: " + gegenstand3.getTyp());

        // Vergleich der Gewichte der Artikel
        int ergebnis = gegenstand1.compareTo(gegenstand2);
        if (ergebnis < 0) {
            System.out.println(gegenstand1.getName() + " ist leichter als " + gegenstand2.getName());
        } else if (ergebnis > 0) {
            System.out.println(gegenstand1.getName() + " ist schwerer als " + gegenstand2.getName());
        } else {
            System.out.println(gegenstand1.getName() + " hat dasselbe Gewicht wie " + gegenstand2.getName());
        }

        Lagerhalle lagerhalle = new Lagerhalle("Beispielstraße", 123, "Beispiel-Bundesland", 98765);

        lagerhalle.bestandHinzu(gegenstand1, 5); // 5 Artikel von gegenstand1 dem Lager hinzufügen
        lagerhalle.bestandHinzu(gegenstand2, 10); // 10 Artikel von gegenstand2 dem Lager hinzufügen
        lagerhalle.bestandHinzu(gegenstand3, 3); // 3 Artikel von gegenstand3 dem Lager hinzufügen

        System.out.println("Lagerdetails:");
        System.out.println("Straße: " + lagerhalle.getStrasse());
        System.out.println("Hausnummer: " + lagerhalle.getHausnummer());
        System.out.println("Bundesland: " + lagerhalle.getStaat());
        System.out.println("Postleitzahl: " + lagerhalle.getPlz());
        System.out.println("Lager-ID: " + lagerhalle.getId());

        System.out.println("Lagerbestand:");
        System.out.println(lagerhalle.bestandDesLagers());

        // Anzahl von gegenstand1 im Lager abrufen
        System.out.println("Anzahl von Gegenstand1: " + lagerhalle.bestandAnzahlGegenstands(gegenstand1));
    }
}