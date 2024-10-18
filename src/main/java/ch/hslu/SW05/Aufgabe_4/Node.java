package ch.hslu.SW05.Aufgabe_4;

public class Node<T> {
    private T object;
    private Node<T> next;

    public Node(T object){
        this.object = object;
    }

    public T getObject(){
        return object;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getNext(){
        return next;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
