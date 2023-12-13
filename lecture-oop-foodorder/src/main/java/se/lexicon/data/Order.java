package se.lexicon.data;

import se.lexicon.model.Product;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class Order implements IOrder {

    private String orderId;
    private LocalDateTime dateTime;
    private Product[] items;

    public Order(){
        this.orderId = UUID.randomUUID().toString();
        this.dateTime = LocalDateTime.now();
        this.items = new Product[0];
    }

    @Override
    public Product[] getItems() {
        return Arrays.copyOf(items, items.length);
    }


    @Override
    public int numberOfItems() {
        return items.length;
    }

    @Override
    public void addItem(Product item) {
        if (item == null) throw new IllegalArgumentException("Item was null");
        Product[] newArray = Arrays.copyOf(items, items.length +1);
        newArray[newArray.length-1] = item;
        items = newArray;
    }

    @Override
    public void removeItem(Product item) {
        //TODO - Implement Methods
    }

}
