package se.lexicon.util_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    /*
    Consumer<T>
    void accept(T t);

    Use Case:
        Print element of a collection
        Modify element in a collection
        Perform an action on the element while iterating
     */

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

        Consumer<Account> printAccountInfo =
                (account) -> System.out.println(account.getUsername() + " " + account.getRole());

        Consumer<Account> printAccountDetails = (account) -> System.out.println(account.toString());

        Consumer<Account> activateAccount = account -> account.activate();

        accounts.forEach(printAccountInfo);




        System.out.println("------------");
//        accounts.forEach(account -> account.activate());

        accounts.forEach(Account::activate);

//        accounts.forEach((account) -> System.out.println(account) );
        accounts.forEach(System.out::println);




        accounts.forEach(printAccountDetails);










    }
}
