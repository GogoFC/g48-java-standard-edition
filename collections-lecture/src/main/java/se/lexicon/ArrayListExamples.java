package se.lexicon;

import java.util.*;

public class ArrayListExamples {

    public static void main(String[] args) {
        ex7();

    }

    public static void ex1(){

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100); //[100]
        numbers.add(100); //[100, 100]
        numbers.add(400); // //[100, 100, 400]
        numbers.add(300);
        numbers.add(200);

        System.out.println(numbers);
        System.out.println("numbers.size() = " + numbers.size()); // 5


        System.out.println("Access element with index 0 = " + numbers.get(0));
        System.out.println("Access element with index 1 = " + numbers.get(1));
        System.out.println("Access element with index 2 = " + numbers.get(2));
//        System.out.println("Access element with index 5 = " + numbers.get(5)); // Throws IndexOutOfBoundsException: Index 5 out of bounds for length 5

        System.out.println("-----------Okay to modify----------");
        Iterator<Integer> numberIterator = numbers.iterator();
        while(numberIterator.hasNext()){
            Integer number = numberIterator.next();
            System.out.println(number);
            if (number.equals(400)){
                numberIterator.remove();
            }
        }

        System.out.println("---------For Print out - Not Modify------------");
        for (Integer number : numbers){
            System.out.println(number);

            if (number.equals(400)){
//                numbers.remove(number); // throws exception: java.util.ConcurrentModificationException
            }

        }


        System.out.println("------------");
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }






    }

    public static void ex2(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(100);
        numbers.add(400);
        numbers.add(300);
        numbers.add(200);

        System.out.println(numbers.size());

//        numbers.remove(new Integer(400)); // Deprecated
        boolean isRemoved = numbers.remove(Integer.valueOf(400));// ✅
        System.out.println("Result = " + isRemoved);
        System.out.println(numbers.size());

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(1));
        }


    }


    public static void ex3(){

        List<String> euCars = new ArrayList<>();
        euCars.add("Volvo");
        euCars.add("VW");
        euCars.add("Volvo");


        List<String> usCars = new ArrayList<>();
        usCars.add("Tesla");
        usCars.add("Ford");

        euCars.addAll(1,usCars);

        for (String car : euCars){
            System.out.println(car);
        }

        System.out.println(euCars.indexOf("Volvo"));
        System.out.println(euCars.lastIndexOf("Volvo"));

    }

    public static void ex4(){

        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("D");
        originalList.add("B");
        originalList.add("A");
        originalList.add("C");
        originalList.add("a");


        ArrayList<String> referenceList = originalList;
        originalList.remove(0);

        System.out.println("originalList.size() = " + originalList.size());
        System.out.println("referenceList.size() = " + referenceList.size());

        ArrayList<String> copyList = (ArrayList<String>) originalList.clone(); // Casting

        originalList.remove(0);
        System.out.println("originalList.size() = " + originalList.size());
        System.out.println("copyList.size() = " + copyList.size());
        
    }
    public static void ex5(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

//        numbers.sort(null);
        numbers.sort(Collections.reverseOrder());

        System.out.println(numbers);

        ArrayList<String> letters = new ArrayList<>();
        letters.add("D");
        letters.add("B");
        letters.add("A");
        letters.add("C");
        letters.add("a");

//        Collections.sort(letters); // [A,B,C,D,a]
        Collections.sort(letters, String.CASE_INSENSITIVE_ORDER); // [A,a,B,C,D]

        System.out.println(letters);


    }

    public static void ex6(){
        String test1 = "TEST";
        String test2 = "TEST";

        boolean isCompareTwoStrings = test1.equals(test2);
        System.out.println("isCompareTwoStrings = " + isCompareTwoStrings);

        System.out.println(test1.hashCode()); // 2571410
        System.out.println(test2.hashCode()); // 2571410
        System.out.println("test".hashCode()); // 3556498

    }

    public static void ex7(){
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person(3, "John", "Doe", "jon@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johanson", "bob@test.se");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        System.out.println("people.size() = " + people.size());
//        System.out.println(people);
        for (Person person : people){
            System.out.println(person);
        }

        System.out.println("-------------");

        Collections.sort(people);
        System.out.println("Sorted List By using natural ordering (id)");
        for (Person person : people){
            System.out.println(person);
        }


        System.out.println("-------");
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastName().compareTo(o2.getLastName());
//            }
//        });

//        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        Collections.sort(people, Comparator.comparing(Person::getFirstName));

        System.out.println("Sorted List By implementing a logic (first name)");
        for (Person person : people){
            System.out.println(person);
        }



    }
}
