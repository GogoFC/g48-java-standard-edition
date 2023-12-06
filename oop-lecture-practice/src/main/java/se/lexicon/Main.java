package se.lexicon;

public class Main {
    public static void main(String[] args)
    {
        Customer simon = new Customer("Simon Elbrink", "simon@lexicon.se", "070 500 10 20");
        System.out.println("simon = " + simon);


        BankAccount account = new BankAccount(100, simon);
        BankAccount bankAccount = new BankAccount(9000, simon);


        System.out.println("account.getBalance() = " + account.getBalance());

        System.out.println("Deposit!");
        account.deposit(500);

        System.out.println("account.getBalance() = " + account.getBalance());

        System.out.println("Withdraw");
        account.withdraw(300);
//        account.withdraw(-300);
//        account.withdraw(900);

        System.out.println("account.getBalance() = " + account.getBalance());


        System.out.println("account = " + account);
        System.out.println("bankAccount = " + bankAccount);


    }
}