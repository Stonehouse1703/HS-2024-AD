package ch.hslu.SW03.Aufgabe_02;

public class Node<T> {

    private Node next;
    private Node less;
    private T data;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getLess(){
        return this.less;
    }

    public void setLess(Node<T> less){
        this.less = less;
    }

    public T getData(){
        return this.data;
    }

}
