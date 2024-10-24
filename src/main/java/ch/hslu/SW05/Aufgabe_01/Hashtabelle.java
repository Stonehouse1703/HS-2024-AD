package ch.hslu.SW05.Aufgabe_01;

import java.lang.reflect.Array;

import static java.util.Objects.hash;

public class Hashtabelle<T> {
    private int[] array;

    public Hashtabelle(int groesse){
        array = new int[groesse];
    }

    public void add(int number){
        int value = hash(number) % array.length;
        if (array[value] != 0){
            throw new IllegalArgumentException("Dieser Slot ist schon belegt");
        }
        array[value] = number;
    }

    public boolean search(int number){
        int value = hash(number) % array.length;
        return array[value] == number;
    }

    public void remove(int number){
        int value = hash(number) % array.length;
        array[value] = 0;
    }

    @Override
    public String toString() {
        String ausgabe = "";

        for (int i = 0; i < array.length; i++){
            ausgabe += "Index: " + i + " Wert = " + array[i] + "\n";
        }

        return ausgabe;
    }
}
