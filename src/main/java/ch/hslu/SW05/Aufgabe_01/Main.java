package ch.hslu.SW05.Aufgabe_01;

public class Main {
    public static void main(String[] args) {
        Hashtabelle tabelle = new Hashtabelle(10);


        tabelle.add(3);
        System.out.println(tabelle.search(3));
        tabelle.remove(3);
        tabelle.add(6);
        tabelle.add(7);
        tabelle.add(8);
        tabelle.add(9);
        tabelle.add(12);

        System.out.println(tabelle.toString());
    }
}
