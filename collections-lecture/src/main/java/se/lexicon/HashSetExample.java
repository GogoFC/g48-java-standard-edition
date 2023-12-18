package se.lexicon;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetExample {

    public static void main(String[] args) {
        ex2();
    }

    public static void ex1(){

//        TreeSet<String> countries = new TreeSet<>(); // Sorted and no duplicates
        HashSet<String> countries = new HashSet<>(); // No Duplicates
        countries.add("Sweden");
        countries.add("Iran");
        countries.add("India");
        countries.add("USA");
        countries.add("Sweden"); // No Duplicates

        System.out.println(countries);
        System.out.println(countries.size());

    }

    public static void ex2(){
        HashSet<Person> people = new HashSet<>();
        Person person1 = new Person(3, "John", "Doe", "jon@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johanson", "bob@test.se");
        Person person4 = new Person(2, "Bob", "Johanson", "bob@test.se"); // Duplicated Object

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        System.out.println(people.size());

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());
        System.out.println(person4.hashCode()); // Should be the same as person3



    }
}
