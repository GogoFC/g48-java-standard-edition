package se.lexicon.data;

import se.lexicon.model.Product;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public interface IOrder {

    int MAX_ITEMS = 10;



    Product[] getItems();


    default double calcPrice(){
        double total = 0;

        for (Product item : getItems()) {
            total += item.getPrice();
        }

        return total;
    }

    default double calcPriceWithTax(){
        double total = 0;
        for (Product item : getItems()) {
            total += item.getPrice() + item.calculateTaxes();
        }

//        DecimalFormat df = new DecimalFormat("#.##"); // Specify the format pattern
//        df.setRoundingMode(RoundingMode.HALF_UP); // Specify the rounding mode
//
//        String formattedNumber = df.format(total);
//        return Double.parseDouble(formattedNumber);

        return total;

    }

    int numberOfItems();

    void addItem(Product item);


    void removeItem(Product item);

    default void displayItems(){

        int counter = 1;
        for (Product item : getItems()) {
            System.out.println("Order [" + counter++ + "]-------");
            item.displayInfo();
        }

        System.out.println("###################");
        System.out.println("Total Order cost: " + calcPrice());
        System.out.println("Total Order cost with Tax: " + calcPriceWithTax());
        System.out.println("###################");

    }
}
