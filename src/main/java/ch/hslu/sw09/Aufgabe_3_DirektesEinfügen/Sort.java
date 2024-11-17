package ch.hslu.sw09.Aufgabe_3_DirektesEinfügen;

import java.util.Arrays;

public class Sort {

    public static void insertionSort2(final int[] a) {
        int elt;
        int j;
        for (int i = 1; i < a.length; i++) {  // Start bei i = 1, da a[0] bereits sortiert ist
            elt = a[i];  // Das nächste Element zum Einfügen
            j = i;  // Die sortierten Elemente sind von a[0] bis a[j-1]

            // Verschiebe alle Elemente, die größer als elt sind, nach rechts
            while (j > 0 && a[j - 1] > elt) {
                a[j] = a[j - 1];  // Verschiebe das Element nach rechts
                j--;  // Gehe weiter nach links
            }

            a[j] = elt;  // Setze das Element an die richtige Stelle
        }
    }

    public static void bubbleSortDIY(final int[] array){
        int pos1;
        int pos2;
        int zwischenSpeicher;
        boolean switched = false;

        for(int j = 0; j < array.length - 1; j++){

            for (int i = 0; i < array.length - 1 - j; i++) {
                pos1 = i;
                pos2 = i + 1;

                if (array[pos1] > array[pos2]) {
                    zwischenSpeicher = array[pos1];
                    array[pos1] = array[pos2];
                    array[pos2] = zwischenSpeicher;
                    switched = true;
                }
            }

            if(switched == false){
                return;
            }
        }
    }

    public static void selectionSortDIY(final int[] array){
        int position = 0;
        int lowestNumber = Integer.MAX_VALUE;

        for (int j = 0; j < array.length; j++){
            for (int i = j; i < array.length; i++){
                if(array[i] < lowestNumber){
                    lowestNumber = array[i];
                    position = i;
                }
            }

            if(array[j] > lowestNumber){
                array[position] = array[j];
                array[j] = lowestNumber;
            }

            lowestNumber = Integer.MAX_VALUE;
            position = 0;
        }
    }

    public static void shellSortDIY(final int[] array) {
        int n = array.length;
        int zwischenspeicher;

        // Schritte definieren
        int[] schritte = {4, 2, 1};

        // Gehe durch die Schrittweiten
        for (int schritt : schritte) {
            // Sortiere Elemente, die durch die aktuelle Schrittweite getrennt sind
            for (int i = schritt; i < n; i++) {
                zwischenspeicher = array[i];
                int j = i;

                // Verschiebe Elemente innerhalb der Teilgruppe, die größer als zwischenspeicher sind
                while (j >= schritt && array[j - schritt] > zwischenspeicher) {
                    array[j] = array[j - schritt];
                    j -= schritt;
                }

                // Setze das Element an die richtige Position
                array[j] = zwischenspeicher;
            }
        }
    }

}

