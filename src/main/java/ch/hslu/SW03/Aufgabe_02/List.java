package ch.hslu.SW03.Aufgabe_02;

public class List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public List(){
        this.size = 0;
        head = null;
        tail = null;
    }

    public int getSize(){
        return this.size;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public void add(T inhalt){
        Node<T> newNode = new Node<>(inhalt, this.head);
        if(size == 0){
            this.tail = newNode;
        } else {
            head.setLess(newNode);
        }
        this.head = newNode;
        this.size++;
    }

    public void printListFromHead(){
        Node<T> current = head;

        System.out.print("Head -> ");

        while (current != null){
            System.out.print(current.getData() + ",");
            current = current.getNext();
        }

        System.out.print(" <- Tail");
    }

    public void printListFromTail(){
        Node<T> current = tail;

        System.out.print("\nTail -> ");

        while (current != null){
            System.out.print(current.getData() + ",");
            current = current.getLess();
        }

        System.out.print(" <- Head");
    }

    public T getIndexFromHead(int index){
        int currentIndex = 0;
        Node<T> current = head;

        while (currentIndex != index) {
            current = current.getNext();
            currentIndex++;
        }

        return current.getData();
    }

    public T getIndexFromTail(int index){
        int currentIndex = 0;
        Node<T> current = tail;

        while (currentIndex != index) {
            current = current.getLess();
            currentIndex++;
        }

        return current.getData();
    }

    public Node<T> getFirst(){
        Node<T> current = head;
        head = head.getNext();
        return current;
    }

}
