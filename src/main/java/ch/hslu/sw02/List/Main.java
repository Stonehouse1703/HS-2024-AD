package ch.hslu.sw02.List;

import ch.hslu.sw02.Person;


public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(10);
        Person person2 = new Person(20);
        Person person3 = new Person(30);

        List list = new List();

        list.addElement(person1);
        list.addElement(person2);
        list.addElement(person3);

        System.out.println("size of list is: " + list.getSize());
        list.getList();

        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());

        System.out.println(list.getSize());
    }
}
