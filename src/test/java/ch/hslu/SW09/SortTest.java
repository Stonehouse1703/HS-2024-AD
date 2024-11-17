package ch.hslu.SW09;

import ch.hslu.sw09.Aufgabe_3_DirektesEinfügen.Sort;
import org.junit.jupiter.api.BeforeAll; // Korrekte Annotation
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {

    // Deklariere das Array als Instanz-Variable, damit es in allen Testmethoden verfügbar ist
    static int[] data;

    @BeforeAll // Korrekte Annotation für Setup vor allen Tests
    static void erstellen() {
        data = new int[]{10, 8, 4, 2, 0, 11, 4, 2, 1, 6, 0, 3}; // Initialisiere das Array
    }

    public static void assertSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            assertTrue(array[i] >= array[i - 1], "Array is not sorted at index " + i);
        }
    }

    @Test
    void testInsertionSort2() {
        Sort.insertionSort2(data); // Sortiere das Array
        System.out.println(Arrays.toString(data)); // Ausgabe des sortierten Arrays
        assertSorted(data); // Prüfe, ob das Array korrekt sortiert ist
    }

    @Test
    void testBubbleSortDIY() {
        Sort.bubbleSortDIY(data); // Sortiere das Array
        System.out.println(Arrays.toString(data)); // Ausgabe des sortierten Arrays
        assertSorted(data); // Prüfe, ob das Array korrekt sortiert ist
    }


}
