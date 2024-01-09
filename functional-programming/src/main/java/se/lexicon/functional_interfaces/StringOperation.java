package se.lexicon.functional_interfaces;

import se.lexicon.functional_interfaces.interfaces.DoStringStuff;

public class StringOperation implements DoStringStuff {

    @Override
    public String operate(String s1, String s2) {
        return s1 + " " + s2;
    }
}
