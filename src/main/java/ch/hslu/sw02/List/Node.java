package ch.hslu.sw02.List;

public class Node<T> {

    private T element;
    private Node next;

    public Node(T element){
        this.element = element;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public String peekNext(){
        return element.toString();
    }
}
