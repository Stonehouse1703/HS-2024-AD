package ch.hslu.SW03.Aufgabe_03;

public interface Stackable<T> {

    void push(T data);

    T pop();

    T peek();

    boolean isEmpty();

    boolean isFull();

    int size();

}
