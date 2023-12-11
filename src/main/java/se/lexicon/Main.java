package se.lexicon;

import se.lexicon.model.Burger;
import se.lexicon.model.Drink;
import se.lexicon.model.Fries;

public class Main {
    public static void main(String[] args) {
        Burger cheeseBurger = new Burger("Cheeseburger", 99.00, "Beef");
        cheeseBurger.displayInfo();

        System.out.println("-------------");

        Drink cola = new Drink("Cola", 19.00, "Medium");
        cola.displayInfo();

        Fries friesWithoutCheese = new Fries("Normal Fries", 10.00, "No Cheese");
        Fries friesWithGoda = new Fries("Fries", 19.00, "Goda Cheese");
        Fries friesWithChiliCheese = new Fries("Fries", 29.00, "Chili-Cheese");

    }
}