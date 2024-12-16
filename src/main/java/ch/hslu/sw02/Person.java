package ch.hslu.sw02;

public class Person {

    private int alter;

    public Person(int alter){
        this.alter = alter;
    }

    public int getAlter(){
        return alter;
    }

    @Override
    public String toString() {
        return Integer.toString(this.alter);
    }
}
