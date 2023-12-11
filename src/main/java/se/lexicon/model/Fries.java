package se.lexicon.model;

public class Fries extends Product{

    private String cheeseType;

    public Fries(String name, double price, String cheeseType) {
        super(name, price);
        this.cheeseType = cheeseType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("CheeseType: " + cheeseType);
    }
}
