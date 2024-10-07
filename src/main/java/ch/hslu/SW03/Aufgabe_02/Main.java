package ch.hslu.SW03.Aufgabe_02;

public class Main {

    public static void main(String[] args) {

        List<String> list = new List();

        list.add("1");
        list.add("2");
        list.add("3");

        list.printListFromHead();

        list.printListFromTail();

        System.out.println("\n" +list.getIndexFromHead(2));
        System.out.println("\n" +list.getIndexFromTail(2));

        list.getFirst();

        list.printListFromHead();
    }
}
