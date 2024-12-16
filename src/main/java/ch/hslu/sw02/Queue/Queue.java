package ch.hslu.sw02.Queue;

import ch.hslu.sw02.Person;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> arrayList;
    private int start;
    private int size;
    private int end;

    public Queue(int ArraySize){
        new ArrayList<T>(ArraySize);
        arrayList.set(0, (T) new Person(20));
        this.start = 0;
        this.end = 0;
    }

    public int getSize(){
        return this.size;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }

    public void offer(T element) throws Exception {
        if (this.size >= arrayList.size()) {
            throw new Exception("brudi bisch bekifft, kei Platz meh");
        }
        // Element hinzufügen
        if (arrayList.size() > end) {
            arrayList.set(end, element);
        } else {
            arrayList.add(element);
        }
        end = (end + 1) % arrayList.size(); // Modulo für zyklisches Verhalten
        size++;
    }


    public T pull() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        }
        T element = arrayList.get(start);
        start = (start + 1) % arrayList.size(); // Modulo für zyklisches Verhalten
        size--;
        return element;
    }



}
