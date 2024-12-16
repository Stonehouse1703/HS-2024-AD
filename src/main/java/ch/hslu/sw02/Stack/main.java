package ch.hslu.sw02.Stack;

import ch.hslu.sw02.Person;

public class main {

    public static void main(String[] args) {
        Person person1 = new Person(10);
        Person person2 = new Person(20);
        Person person3 = new Person(30);

        Stack stack = new Stack(4);

        stack.push(person1);
        stack.push(person2);
        stack.push(person3);
//        stack.push(person3);
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}