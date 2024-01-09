package se.lexicon.stream_api;


import se.lexicon.stream_api.model.Gender;
import se.lexicon.stream_api.model.Person;
import se.lexicon.stream_api.service.People;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    private static final List<Person> PEOPLE = People.INSTANCE.getPeople();

    public static void main(String[] args) {
        ex6();
    }

    private static void ex1() {
        Stream<Integer> iterate = Stream.iterate(0, integer -> integer + 1);
        iterate.forEach(System.out::println);
    }

    private static void ex2() {
        Person person1 = new Person(1,"Tobias", "Engberg",LocalDate.parse("1999-02-02"), Gender.MALE);
        Person person2 = new Person(2,"Marcus", "Gudmundsen", LocalDate.parse("1998-03-02"), Gender.MALE);
        Person person3 = new Person(3,"Simon", "Elbrink", LocalDate.parse("1997-01-02"), Gender.MALE);

        Stream<Person> people = Stream.of(person1, person2, person3);


        long numberOfPeople = people.count();
        System.out.println("numberOfPeople = " + numberOfPeople);

    }

    public static void ex3(){
        Person person1 = new Person(1,"Tobias", "Engberg",LocalDate.parse("1999-02-02"), Gender.MALE);
        Person person2 = new Person(2,"Marcus", "Gudmundsen", LocalDate.parse("1998-03-02"), Gender.MALE);
        Person person3 = new Person(3,"Simon", "Elbrink", LocalDate.parse("1997-01-02"), Gender.MALE);


        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);


        // Imperative Style

        Person youngestI = null;

        for (Person p : people){
            if ( youngestI == null){
                youngestI = p;
            }else if(p.getDateOfBirth().isAfter(youngestI.getDateOfBirth())){
                youngestI = p;
            }
        }

        System.out.println(youngestI);


        System.out.println("------------------");

        // Declarative Style
        Stream<Person> peopleStream = people.stream();
        //        Optional<Person> oldest = people.min((Person p1, Person p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));


//        Optional<Person> youngest = peopleStream.max((Person p1, Person p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));
//        Optional<Person> youngest = peopleStream.max(Comparator.comparing((person -> person.getDateOfBirth())));
        Optional<Person> youngest = peopleStream.max(Comparator.comparing(Person::getDateOfBirth));

        System.out.println(youngest.get());
    }

    public static void ex4(){


        List<String> words = Arrays.asList("I" ,"love", "programming");


        Optional<String> sentence = words.stream()
                .reduce((w1, w2) -> w1.concat(" " + w2));

        System.out.println(sentence.get());
    }

    public static void ex5(){


        List<Person> list = PEOPLE.stream()
                .filter((person -> person.getGender().equals(Gender.FEMALE)))
                .filter(person -> person.getFirstName().startsWith("M"))
                .filter(person -> person.getDateOfBirth().isBefore(LocalDate.parse("1999-12-31")))
                .toList();
    }

    public static void ex6() {
        // Get FULLNAME of persons born in January 1970

        Set<String> collect = PEOPLE.stream()
                .filter((person -> person.getDateOfBirth().isBefore(LocalDate.parse("1970-02-01"))))
                .filter((person -> person.getDateOfBirth().isAfter(LocalDate.parse("1969-12-31"))))
                .peek(System.out::println) // Debugging
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toSet());

        collect.forEach(System.out::println);

    }

    public static void ex7(){
        // group by lastname


        Map<String, List<Person>> collect = PEOPLE.stream()
                .collect(Collectors.groupingBy(person -> person.getLastName()));

        collect.forEach(((lastname, people) -> {
            System.out.println(lastname);
            System.out.println(people);
        }));
    }

    public static void ex8(){

        PEOPLE.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .filter(person -> person.getLastName().endsWith("sson"))
                .filter(person -> person.getFirstName().endsWith("ka"))
//                .sorted((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getDateOfBirth))
                .forEach(System.out::println);
    }

}

