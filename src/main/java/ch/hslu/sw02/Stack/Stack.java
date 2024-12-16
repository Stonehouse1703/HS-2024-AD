package ch.hslu.sw02.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Stack<T> {

    private int size;
    private ArrayList<T> array;

    public Stack(int arraySize){
        this.size = 0;
        this.array = new ArrayList<T>(arraySize);
    }

    public int getSize(){
        return this.size;
    }

    public void push(T element){
        if (size == array.size() - 1){
            throw new RuntimeException();
        }
        array.add(size, element);
        this.size++;
    }

    public T pop(){
        if (size <= 0){
            return null;
        }
        this.size--;
        return (array.get(size));
    }




}
