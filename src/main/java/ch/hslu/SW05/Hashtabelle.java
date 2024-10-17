package ch.hslu.SW05;

import java.util.Arrays;

public class Hashtabelle<T> {

    private T[] array;


    public Hashtabelle(int size) {
        // Erstelle ein Array von Objekten und caste es zu einem Array vom Typ T[]
        this.array = (T[]) new Object[size];
    }

    // Methode zum Hinzufügen eines Objekts
    public void addObject(T object) {
        int index = getIndex(object.hashCode());

        // Prüfe auf Kollision
        if (array[index] != null) {
            System.out.println("Kollision an Position " + index);
            return;
        }

        // Füge das Objekt in die Tabelle ein
        array[index] = object;
    }

    // Methode zum Suchen eines Objekts
    public boolean searchObject(T object) {
        int index = getIndex(object.hashCode());

        // Prüfen, ob das Objekt vorhanden ist
        if (array[index] != null && array[index].equals(object)) {
            return true;
        }

        return false;
    }

    // Methode zum Entfernen eines Objekts
    public void removeObject(T object) {
        if (!searchObject(object)) {
            System.out.println("Wert ist nicht vorhanden");
            return;
        }

        int index = getIndex(object.hashCode());
        array[index] = null;  // Setze das Element auf null, um es zu entfernen
    }

    // Methode zur Berechnung des Indexes (Hash)
    private int getIndex(int hash) {
        return Math.abs(hash % array.length);
    }

    @Override
    public String toString() {
        StringBuilder ausgabe = new StringBuilder();

        // Durchlaufe das Array und erstelle die Ausgabe
        for (int i = 0; i < array.length; i++) {
            ausgabe.append("Position ").append(i).append(": Wert = ").append(array[i]).append("\n");
        }

        return ausgabe.toString();
    }
}
