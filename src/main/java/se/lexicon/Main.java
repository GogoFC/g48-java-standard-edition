package se.lexicon;

import se.lexicon.data.Order;
import se.lexicon.model.Burger;
import se.lexicon.model.CheeseType;
import se.lexicon.model.Drink;
import se.lexicon.model.Fries;

public class Main {
    public static void main(String[] args) {
        Burger cheeseBurger = new Burger("Cheeseburger", 99.00, "Beef");

        Drink cola = new Drink("Cola", 19.00, "Medium");

        Fries friesWithoutCheese = new Fries("Normal Fries", 10.00, CheeseType.WITHOUT_CHEESE);
        Fries friesWithChiliCheese = new Fries("Fries", 10.00, CheeseType.CHILI_CHEESE);

        System.out.println("--------ORDER----------");

        Order simonsFirstOrder = new Order();
        simonsFirstOrder.addItem(cola);
        simonsFirstOrder.addItem(cheeseBurger);
        simonsFirstOrder.addItem(friesWithoutCheese);
        simonsFirstOrder.displayItems();


    }
}