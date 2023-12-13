package se.lexicon.model;

public enum CheeseType {

    WITHOUT_CHEESE(0),
    GODA(10),
    CHILI_CHEESE(20);

    CheeseType(double price){
        this.price = price;
    }

    private double price;

    public double getPrice(){
        return price;
    }



}
