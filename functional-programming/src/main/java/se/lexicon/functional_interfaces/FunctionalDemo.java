package se.lexicon.functional_interfaces;

import se.lexicon.functional_interfaces.interfaces.DoStringStuff;
import se.lexicon.functional_interfaces.interfaces.DoubleOperator;

public class FunctionalDemo {

    static DoStringStuff concatOperation = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1 + " " + s2;
        }
    };

    static DoStringStuff getBiggest = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1.length() >= s2.length() ? s1 : s2;
        }
    };

    static DoubleOperator additionOperator = new DoubleOperator() {
        @Override
        public Double apply(Double n1, Double n2) {
            return n1 + n2;
        }
    };
    static DoubleOperator subtractionOperator = new DoubleOperator() {
        @Override
        public Double apply(Double n1, Double n2) {
            return n1 - n2;
        }
    };
    static DoubleOperator multiplicationOperator = new DoubleOperator() {
        @Override
        public Double apply(Double n1, Double n2) {
            return n1 * n2;
        }
    };

    public static void main(String[] args) {

        StringOperation concatOperationIMPL = new StringOperation();

        String fullName = concatOperationIMPL.operate("Simon", "Elbrink");
//        System.out.println("fullName = " + fullName);


        System.out.println(concatOperation.operate("Simon", "Elbrink"));
        System.out.println(getBiggest.operate("Simon", "Mehrdad"));

        System.out.println(additionOperator.apply(100d,500d));

        calcOperator(500d,700d, multiplicationOperator);
        calcOperator(500d,200d, subtractionOperator);
        calcOperator(500d,200d, additionOperator);

        System.out.println(doStringStuff("Simon", "Elbrink", concatOperation));


    }

    public static double calcOperator(double n1, double n2, DoubleOperator doubleOperator){
        return doubleOperator.apply(n1,n2);
    }

    public static String doStringStuff(String s1, String s2, DoStringStuff stringOperation){
        return stringOperation.operate(s1, s2);
    }
}
