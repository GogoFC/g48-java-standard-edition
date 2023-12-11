package se.lexicon.model;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo(){
        System.out.println("Item: " + name);
        System.out.println("Price: " + price);
    }

    public double getPrice(){
        return price;
    }


}
