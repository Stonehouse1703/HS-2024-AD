package ch.hslu.SW04.Aufgabe_05;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.addToTree(4);
        tree.addToTree(1);
        tree.addToTree(2);
        tree.addToTree(3);
        tree.addToTree(6);
        tree.addToTree(5);
        tree.addToTree(20);
        tree.addToTree(10);
        tree.addToTree(8);

        System.out.println("hight: " + tree.getHight());
        System.out.println("size: " + tree.getSize());

        tree.search(4);
    }
}
