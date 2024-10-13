package ch.hslu.SW04.Aufgabe_06;

import java.util.Objects;

public class Inhalt<T> {

    private T object;
    private Inhalt<T> left;
    private Inhalt<T> right;
    private int hashCode;

    public Inhalt(T object) {
        this.object = object;
        this.left = null;
        this.right = null;
        this.hashCode = object.hashCode();
    }

    public int getHashCode() {
        return this.hashCode;
    }

    public Inhalt<T> getLeft() {
        return this.left;
    }

    public void setLeft(Inhalt<T> left) {
        this.left = left;
    }

    public Inhalt<T> getRight() {
        return this.right;
    }

    public void setRight(Inhalt<T> right) {
        this.right = right;
    }

    public T getObject() {
        return this.object;
    }
}

