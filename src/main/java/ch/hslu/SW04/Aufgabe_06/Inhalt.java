package ch.hslu.SW04.Aufgabe_06;

import java.util.Objects;

public class Inhalt {
    //------------< Attribute >------------
    int data;
    Inhalt left;
    Inhalt right;

    //------------< Konstruktor >------------
    public Inhalt(String data){
        this.data = data;
        this.right = null;
        this.left = null;
    }

    //------------< Methoden >------------
    public Inhalt getLeft(){
        return this.left;
    }

    public void setLeft(Inhalt left){
        this.left = left;
    }

    public Inhalt getRight(){
        return this.right;
    }

    public void setRight(Inhalt right){
        this.right = right;
    }

    public int getData(){
        return this.data;
    }

}
