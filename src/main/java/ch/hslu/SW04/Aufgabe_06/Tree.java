package ch.hslu.SW04.Aufgabe_06;

public class Tree<T> {

    private Inhalt<T> wurzel;
    private int size;
    private int height;

    public Tree() {
        this.wurzel = null;
        this.size = 0;
        this.height = -1;
    }

    public int getSize() {
        return this.size;
    }

    public int getHeight() {
        return this.height;
    }

    public String searchWithStringAusgabe(T datei) {
        String pfad = "";
        int hashWertFile = datei.hashCode();
        Inhalt<T> currentFile = wurzel;

        while (currentFile != null) {
            if (hashWertFile < currentFile.getHashCode()) {
                currentFile = currentFile.getLeft();
                pfad += "l";
            } else if (hashWertFile > currentFile.getHashCode()) {
                currentFile = currentFile.getRight();
                pfad += "r";
            } else {
                return pfad;  // Datei gefunden, Rückgabe des Pfades
            }
        }

        return "Datei nicht vorhanden";
    }

    public Inhalt<T> search(T datei) {
        int hashWertFile = datei.hashCode();
        Inhalt<T> currentFile = wurzel;

        while (currentFile != null) {
            if (hashWertFile < currentFile.getHashCode()) {
                currentFile = currentFile.getLeft();
            } else if (hashWertFile > currentFile.getHashCode()) {
                currentFile = currentFile.getRight();
            } else {
                return currentFile;  // Datei gefunden
            }
        }

        return null;  // Datei nicht gefunden
    }

    public void add(T datei) {
        Inhalt<T> newFile = new Inhalt<>(datei);
        if (wurzel == null) {
            wurzel = newFile;
            size++;
            height++;
            return;
        }

        Inhalt<T> parent = null;
        Inhalt<T> currentFile = wurzel;
        int currentHeight = 1;  // Startet mit der Wurzelhöhe

        while (currentFile != null) {
            parent = currentFile;
            if (datei.hashCode() < currentFile.getHashCode()) {
                currentFile = currentFile.getLeft();
                currentHeight++;
            } else if (datei.hashCode() > currentFile.getHashCode()) {
                currentFile = currentFile.getRight();
                currentHeight++;
            } else {
                throw new IllegalArgumentException("Datei bereits vorhanden.");
            }
        }

        // Neuen Knoten an die korrekte Stelle setzen
        if (datei.hashCode() < parent.getHashCode()) {
            parent.setLeft(newFile);
        } else {
            parent.setRight(newFile);
        }

        size++;  // Größe erhöhen
        height = Math.max(height, currentHeight);  // Höhe anpassen
    }
}

