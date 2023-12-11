package se.lexicon.model;

public class Fries extends Product{

    private CheeseType cheeseType;

    public Fries(String name, double price, CheeseType cheeseType) {
        super(name, (price + cheeseType.getPrice()) );
        this.cheeseType = cheeseType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("CheeseType: " + cheeseType);
    }
}
