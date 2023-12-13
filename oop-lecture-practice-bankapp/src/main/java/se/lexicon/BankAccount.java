package se.lexicon;

public class BankAccount {
      // move to helper class
//    private static int accountNumberCounter = 0;
//
//    public static int generateAccountNumber(){
//        return ++accountNumberCounter;
//    }

    private int accountNumber;
    private double balance;
    private Customer owner;

    public BankAccount(double balance, Customer owner) {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.balance = balance;
        this.owner = owner;
    }


    public void deposit(double amount){
        if (amount < 0) throw new IllegalArgumentException("Can not deposit a negative number");
//        balance = balance + amount;
        balance += amount;
    }

    public void withdraw(double amount){
        if (amount < 0) throw new IllegalArgumentException("Can not withdraw a negative number");
        if (amount > balance) throw new IllegalArgumentException("Withdraw denied: Insufficient founds.");
        balance -= amount;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return new java.util.StringJoiner(", ", BankAccount.class.getSimpleName() + "[", "]")
                .add("accountNumber=" + accountNumber)
                .add("balance=" + balance)
                .add("owner=" + owner)
                .toString();
    }
}
