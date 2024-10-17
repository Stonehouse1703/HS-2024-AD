package ch.hslu.SW05;

public class Main {
    public static void main(String[] args) {
        Hashtabelle hashtabelle = new Hashtabelle(5);

        hashtabelle.addInt(1);
        hashtabelle.addInt(2);
        hashtabelle.addInt(3);


        System.out.println(hashtabelle.toString());


        System.out.println(hashtabelle.searchIntergerBoolean(3));

        hashtabelle.removeInterger(3);

        System.out.println(hashtabelle.searchIntergerBoolean(3));
    }
}
