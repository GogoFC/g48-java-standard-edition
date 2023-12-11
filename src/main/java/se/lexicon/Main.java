package se.lexicon;

import se.lexicon.model.Burger;
import se.lexicon.model.Drink;

public class Main {
    public static void main(String[] args) {
        Burger cheeseBurger = new Burger("Cheeseburger", 99.00, "Beef");
        cheeseBurger.displayInfo();

        System.out.println("-------------");

        Drink cola = new Drink("Cola", 19.00, "Medium");
        cola.displayInfo();

    }
}