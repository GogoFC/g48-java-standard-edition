package se.lexicon.functional_interfaces;

import se.lexicon.functional_interfaces.interfaces.DoStringStuff;
import se.lexicon.functional_interfaces.interfaces.DoubleOperator;
import se.lexicon.functional_interfaces.interfaces.IntRandom;
import se.lexicon.functional_interfaces.interfaces.Printer;

import java.util.Random;

public class LambdaDemo {


    //String operate(String s1, String s2);
    static DoStringStuff concatOperation = (s1, s2) -> s1 + " " + s2;
    static DoStringStuff getBiggestString = (s1, s2) -> s1.length() >= s2.length() ? s1 : s2;

    static DoubleOperator additionOperator = (n1, n2) -> n1 + n2;
    static DoubleOperator subtractionOperator = (n1, n2) -> n1 - n2;



    public static String doStringStuff(String s1, String s2, DoStringStuff stringOperation){
        return stringOperation.operate(s1, s2);
    }

    public static double calcOperator(double n1, double n2, DoubleOperator operator) {
        return operator.apply(n1, n2);
    }

    public static void main(String[] args) {

        System.out.println(concatOperation.operate("Simon", "Elbrink"));
        System.out.println(getBiggestString.operate("Simon", "Elbrink"));
        System.out.println("------------------------------");
        System.out.println(doStringStuff("Simon", "Elbrink", concatOperation));
        System.out.println(doStringStuff("Simon", "Elbrink", getBiggestString));
        System.out.println("-----------------------------");
        System.out.println(additionOperator.apply(12d, 10d));
        System.out.println(subtractionOperator.apply(12d, 10d));
        System.out.println("------------------------------");
        System.out.println(calcOperator(12d,10d, additionOperator));
        System.out.println(calcOperator(12d,10d, subtractionOperator));

        System.out.println("------------------------------");
        IntRandom randomNumberOperator = () -> new Random().nextInt();
        System.out.println(randomNumberOperator.generate());
        System.out.println("------------------------------");
        Printer printMessage = message -> System.out.println(message);
//        Printer printMessage = System.out::println;
        printMessage.print("Hello Group!");





    }



    //    static DoStringStuff getBiggestString = (s1, s2) -> {
//        if(s1.length() >= s2.length()){
//            return s1;
//        }else {
//            return s2;
//        }
//    };


}
