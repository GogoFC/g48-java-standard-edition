package se.lexicon;

public class AccountNumberGenerator {
    private static int accountNumberCounter = 0;

    public static int generateAccountNumber(){
        return ++accountNumberCounter;
    }
}
