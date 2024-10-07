package ch.hslu.SW03.Aufgabe_03;

public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(5);

        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");
        System.out.println(stack.peek());
        stack.push(";)");
        stack.push("5");

        for (int i = stack.size(); i > 0; i--){
            System.out.println(stack.pop());
        }

    }

}
