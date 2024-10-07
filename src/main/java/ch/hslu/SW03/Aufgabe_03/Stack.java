package ch.hslu.SW03.Aufgabe_03;

import java.lang.reflect.Array;

public class Stack<T> implements Stackable<T>{

    private int size;
    private T[] stackArray;

    public Stack(int size){
        stackArray = (T[]) new Object[size];
        this.size = -1;
    }

    @Override
    public void push(final T data) {
        if (isFull()){
            throw new IllegalArgumentException("Stack ist voll");
        }
        stackArray[++size] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalArgumentException("Stackk ist leer");
        }
        return stackArray[size--];
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalArgumentException("Stackk ist leer");
        }
        return stackArray[size];
    }

    @Override
    public boolean isEmpty() {
        return size == -1;
    }

    @Override
    public boolean isFull() {
        return size == stackArray.length - 1;
    }

    @Override
    public int size() {
        return size + 1;
    }

}
