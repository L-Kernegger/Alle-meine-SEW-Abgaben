# Basis für das Beispiel Figuren 

Dieses Beispiel basiert auf der Java-Struktur zur Erstellung einer Java-Applikation.
Alle Abgaben entlang des Softwareentwicklungsprozesses können hier eingepflegt werden:

- bin: enthält alle Files, zur Ausführung,...
- design: enthält alle Dokumente des Softwaredesigns
- doc: enthält die Dokumentation (JavaDoc)
- resource: enthält Media-Files
- src: enthält den Sourcecode (Packages, Files)
- test: enthält die Testfälle, welche den Sourcecode testen

Im src-Ordner sind folgende Packages und Klassen als Ausgangspunkt verfügbar:
- figuren.model.Konstanten: Interface, das Konstanten für die GUI enthält. Derzeit ist eine Liste mit Farben und zugehörigen Farbnamen gespeichert.
- figuren.model.Rechteck: Eine Klasse, die alle Daten und Methoden enthält, um ein Rechteck zu zeichnen.
- figuren.model.FigurenListe: Verwaltet eine Liste an Rechtecken
- figuren.view.RechteckGraphics: Zeichenfläche zum Darstellen der Rechtecke.
- figuren.view.FigurPanel: Layout für das Erstellen, Verwalten und Zeichnen von Rechtecken
- figuren.view.FigurFrame: Klasse zum Darstellen des Layouts in einem Fenster.