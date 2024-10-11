package ch.hslu.SW04.Aufgabe_06;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.addToTree("aa");
        tree.addToTree("ab");
        tree.addToTree("ac");
        tree.addToTree("ad");
        tree.addToTree("ae");
        tree.addToTree("af");
        tree.addToTree("ag");
        tree.addToTree("ah");
        tree.addToTree("ai");

        System.out.println("hight: " + tree.getHight());
        System.out.println("size: " + tree.getSize());

        tree.search(4);
    }
}
