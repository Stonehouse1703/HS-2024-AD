package ch.hslu.SW03.Aufgabe_04;

public class Main {

    public static void main(String[] args) {

        Queue<Character> queue = new Queue<>(8);
        // Hinzufügen eines Char-Elements zur Queue
        System.out.println(queue.getIndex());
        queue.enqueue('A');
        System.out.println(queue.getIndex());
        queue.enqueue('B');
        System.out.println(queue.getIndex());
        queue.enqueue('C');
        System.out.println(queue.getIndex());
        queue.enqueue('D');
        System.out.println(queue.getIndex());
        queue.enqueue('E');

        for (int i = queue.getUsedSize(); i > 0; i--){
            System.out.println(queue.getIndex());
            System.out.println(queue.dequeueue());
        }

        System.out.println(queue.getIndex());
        queue.enqueue('A');
        System.out.println(queue.getIndex());
        queue.enqueue('B');
        System.out.println(queue.getIndex());
        queue.enqueue('C');
        System.out.println(queue.getIndex());
        queue.enqueue('D');
        System.out.println(queue.getIndex());
        queue.enqueue('E');

        for (int i = queue.getUsedSize(); i > 0; i--){
            System.out.println(queue.getIndex());
            System.out.println(queue.dequeueue());
        }


    }
}
