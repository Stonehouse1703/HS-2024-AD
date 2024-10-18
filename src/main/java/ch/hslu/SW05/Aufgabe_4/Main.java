package ch.hslu.SW05.Aufgabe_4;

public class Main {

    public static void main(String[] args) {
        Hashtabelle hashtabelle = new Hashtabelle(10);

        Zahl nr1 = new Zahl(1);
        Zahl nr11 = new Zahl(11);

        hashtabelle.addObject(nr1);
        hashtabelle.addObject(nr11);

        System.out.println(hashtabelle.toString());
    }
}
