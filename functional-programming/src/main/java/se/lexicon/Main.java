package se.lexicon;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static int add(int number1, int number2) {return number1 + number2;}



    public static void main(String[] args) {

        //T = Parameter 1 = Integer
        //U = Parameter 2 = Integer
        //R = Return = Integer

//        BiFunction<Integer, Integer ,Integer> addition = (a, b) -> add(a,b);
        BiFunction<Integer, Integer ,Integer> addition = Main::add;


        System.out.println("Hello world!");
    }
}


