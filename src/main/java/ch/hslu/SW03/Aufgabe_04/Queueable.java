package ch.hslu.SW03.Aufgabe_04;

public interface Queueable<T> {

    void enqueue(T data);

    T dequeueue();

    T peek();

    boolean isFull();

    boolean isEmpthy();

}
