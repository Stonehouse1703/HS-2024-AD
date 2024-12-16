package ch.hslu.sw02.Queue;

import ch.hslu.sw02.Person;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person(10);
        Person person2 = new Person(20);
        Person person3 = new Person(30);

        Queue queue = new Queue(3);

        queue.offer(person1);
        queue.offer(person2);
        queue.offer(person3);


    }
}
