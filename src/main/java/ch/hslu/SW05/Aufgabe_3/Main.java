package ch.hslu.SW05.Aufgabe_3;

public class Main {

    public static void main(String[] args) {
        Hashtabelle<Zahl> hashtabelle = new Hashtabelle<>(10);

        Zahl nr1 = new Zahl(1);
        Zahl nr2 = new Zahl(2);
        Zahl nr11 = new Zahl(11);
        Zahl nr9 = new Zahl(9);
        Zahl nr19 = new Zahl(19);
        Zahl nr29 = new Zahl(29);

//        hashtabelle.addObject(nr1);
//        hashtabelle.addObject(nr2);
//        hashtabelle.addObject(nr11);
//        hashtabelle.addObject(nr9);
//        hashtabelle.addObject(nr19);
//        hashtabelle.addObject(nr29);
//
//        hashtabelle.removeObject(nr2);
//        hashtabelle.removeObject(nr19);
//
//        System.out.println(hashtabelle.toString());
//        System.out.println(hashtabelle.objectVorhanden(nr29));

        hashtabelle.addObject(nr1);
        hashtabelle.addObject(nr2);
        hashtabelle.addObject(nr11);

        System.out.println(hashtabelle.toString());

        hashtabelle.removeObject(nr2);

        System.out.println(hashtabelle.toString());

        hashtabelle.removeObject(nr11);

        System.out.println(hashtabelle.toString());

    }
}
