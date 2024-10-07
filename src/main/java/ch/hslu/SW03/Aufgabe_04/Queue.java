package ch.hslu.SW03.Aufgabe_04;

public class Queue<T> implements Queueable<T>{

    private int index;
    private int usedSize;
    private T[] array;

    public Queue(int size){
        array = (T[]) new Object[size];
        this.index = 0;
        this.usedSize = -1;
    }

    @Override
    public void enqueue(T data) {
        if (isFull()){
            throw new IllegalArgumentException("ist Voll");
        }
        array[index] = data;
        usedSize++;
        if (index > array.length){
            index = 0;
        } else {
            index++;
        }
    }

    @Override
    public T dequeueue() {
        if (isEmpthy()){
            throw new IllegalArgumentException("ist leer");
        }
        usedSize--;
        return array[index--];
    }

    @Override
    public T peek() {
        return array[index];
    }

    @Override
    public boolean isFull() {
        return this.usedSize == array.length - 1;
    }

    @Override
    public boolean isEmpthy() {
        return this.usedSize == -1;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public int getIndex(){
        return index;
    }
}
