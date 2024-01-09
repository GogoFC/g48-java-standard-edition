package se.lexicon.functional_interfaces.interfaces;

@FunctionalInterface
public interface DoStringStuff {

    //Only one abstract Method is allowed in a functional Interface
    String operate(String s1, String s2);

    //Allowed to have any number of static or default methods.

    //...
}
