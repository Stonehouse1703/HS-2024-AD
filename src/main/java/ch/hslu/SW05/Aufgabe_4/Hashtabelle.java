package ch.hslu.SW05.Aufgabe_4;

import ch.hslu.SW05.Aufgabe_3.Zahl;
import java.util.Objects;

public class Hashtabelle<T> {

    private Object[] array; // Verwenden von Object[], um Casting-Probleme zu vermeiden.
    private T platzhalter;

    public Hashtabelle(int size) {
        this.array = new Object[size]; // Initialisieren des Arrays mit Object[]
        this.platzhalter = (T) new Zahl(Integer.MAX_VALUE); // Beispielplatzhalter
    }

    public void addObject(T object) {
        int index = hashIndex(object);

        // Wenn an der Stelle nichts existiert, neue Liste erstellen und Objekt hinzufügen
        if (array[index] == null) {
            List<T> list = new List<>();
            list.addObject(object);
            array[index] = list;
        } else {
            // Wenn bereits eine Liste existiert, Objekt in die Liste einfügen (Verkettung)
            List<T> list = (List<T>) array[index];

            // Prüfen, ob das Objekt schon vorhanden ist
            if (!containsObject(list, object)) {
                list.addObject(object);
            }
        }
    }

    // Methode zur Überprüfung, ob das Objekt in der Liste bereits vorhanden ist
    private boolean containsObject(List<T> list, T object) {
        Node<T> currentNode = list.getHeader(); // getHeader() Methode annehmen
        while (currentNode != null) {
            if (Objects.equals(currentNode.getObject(), object)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    private int hashIndex(T object) {
        return Math.abs(object.hashCode() % array.length); // abs() hinzufügen, um negative Indizes zu vermeiden
    }

    @Override
    public String toString() {
        StringBuilder wert = new StringBuilder(); // StringBuilder statt String für bessere Performance

        for (int i = 0; i < array.length; i++) {
            wert.append("Index: ").append(i).append(" Wert = ");
            if (array[i] == null) {
                wert.append("null\n");
            } else {
                List<T> list = (List<T>) array[i];
                wert.append(list.toString()).append("\n");
            }
        }

        return wert.toString();
    }
}
