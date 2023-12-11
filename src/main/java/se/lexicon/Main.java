package se.lexicon;

import se.lexicon.model.Burger;
import se.lexicon.model.CheeseType;
import se.lexicon.model.Drink;
import se.lexicon.model.Fries;

public class Main {
    public static void main(String[] args) {
        Burger cheeseBurger = new Burger("Cheeseburger", 99.00, "Beef");
        cheeseBurger.displayInfo();

        System.out.println("-------------");

        Drink cola = new Drink("Cola", 19.00, "Medium");
        cola.displayInfo();

        Fries friesWithoutCheese = new Fries("Normal Fries", 10.00, CheeseType.WITHOUT_CHEESE);
        Fries friesWithGoda = new Fries("Fries", 10.00, CheeseType.GODA);
        Fries friesWithChiliCheese = new Fries("Fries", 10.00, CheeseType.CHILI_CHEESE);


        friesWithoutCheese.displayInfo();
        friesWithChiliCheese.displayInfo();

    }
}