package ch.hslu.SW04.Aufgabe_06;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Hans", "Peter", "hansPeter@gmail.com", 69);
        Person person2 = new Person("Peter", "Hans", "hansPeter35@gmail.com", 35);
        Person person3 = new Person("John", "Muster", "john@gmail.com", 5);
        Person person4 = new Person("a", "w", "aw@gmail.com", 50);
        Person person5 = new Person("b", "x", "bx@gmail.com", 23);
        Person person6 = new Person("c", "y", "cy@gmail.com", 34);
        Person person7 = new Person("d", "z", "dz@gmail.com", 67);

        Tree<Person> tree = new Tree<>();

        tree.add(person1);
        tree.add(person2);
        tree.add(person3);
        tree.add(person4);
        tree.add(person5);
        tree.add(person6);
        tree.add(person7);

        System.out.println("person1 " + person1.hashCode());
        System.out.println("person2 " + person2.hashCode());
        System.out.println("person3 " + person3.hashCode());
        System.out.println("person4 " + person4.hashCode());
        System.out.println("person5 " + person5.hashCode());
        System.out.println("person6 " + person6.hashCode());
        System.out.println("person7 " + person7.hashCode());

        //                              1.519.889.567 (Person 1)
        //                              /                        \
        //                  -502.289.151 (Person 2)            1.986.774.727 (Person 5)
        //                  /               \
        //    -1.001.653.956 (Person 3)     318.906.087 (Person 6)
        //      /                       \
        //  -1.348.962.553(Person 7)     -640.323.929 (Person 4)

        System.out.println(tree.getSize());
        System.out.println(tree.searchWithStringAusgabe(person4));
    }
}
