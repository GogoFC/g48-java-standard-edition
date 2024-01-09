package se.lexicon.util_function;

import se.lexicon.functional_interfaces.LambdaDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
public class FunctionDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("DEV1", Role.ROLE_USER);
        Account account2 = new Account("DEV2", Role.ROLE_USER);
        Account account3 = new Account("DEV3", Role.ROLE_USER);

        Account account4 = new Account("MANAGER1", Role.ROLE_ADMIN);
        Account account5 = new Account("MANAGER2", Role.ROLE_ADMIN);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);




        Account accountUser = new Account("user", Role.ROLE_USER);

        Function<Account, String> extractUserPass =
                (account) -> account.getUsername() + " " + account.getPassword();

        Function<Account, String> userNameUpperCase = (account) -> account.getUsername().toUpperCase();

        String userName_and_Password = extractUserPass.apply(accountUser);

        System.out.println(userName_and_Password);


        System.out.println("-----------");

        List<String> strings = applyToList(accounts, extractUserPass);
        strings.forEach(System.out::println);

        applyToList(accounts, userNameUpperCase).forEach(System.out::println);




        //T = Parameter 1 = Integer
        //U = Parameter 2 = Integer
        //R = Return = Integer

//        BiFunction<Integer, Integer ,Integer> addition = (a, b) -> add(a,b);
        BiFunction<Integer, Integer ,Integer> addition = FunctionDemo::add;




    }

    public static int add(int number1, int number2) {return number1 + number2;}


    public static List<String> applyToList (List<Account> accountList, Function<Account ,String> extract){
        List<String> newextractedList = new ArrayList<>();

        for (Account a : accountList){
            newextractedList.add(extract.apply(a));
        }

        return newextractedList;
    }
}
