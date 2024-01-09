package se.lexicon.util_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    // Predicate<T>
    // boolean test(T t);
    /*
        UseCase:
        Filtering in a Collection
        Select element from a Stream
        Writing more concise and expressive code when dealing with condition(if statements)
     */

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            numbers.add(i);
        }
        // [1,2,3,4,5,6,7,8,9,10]
        System.out.println(numbers);


        Predicate<Integer> isEven = (number) -> number % 2 == 0;

        Predicate<Integer> isGreaterThen25 = number -> number >= 25;
        Predicate<Integer> isLesserThen = n -> n <18;

/*        List<Integer> filteredListOfNumbers = new ArrayList<>();

        for (Integer integer : numbers){
            if (isEven.test(integer)){
                filteredListOfNumbers.add(integer);
            }
        }    */


        System.out.println("-----------");

        System.out.println(filter(numbers,isEven)); // [2,4,6,8,10]
        System.out.println(filter(numbers,isEven.negate())); // [1,3,5,7,9]


    }

    public static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate){
        List<Integer> result = new ArrayList<>();

        for (Integer integer : numbers){
            if (predicate.test(integer)){
                result.add(integer);
            }
        }

        return result;
    }

}
