package uml;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {
    public Array itemList;
    private Customer customer;
    private List<Item> items;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    public void contains(Item... item) {
        items.addAll(Arrays.asList(item));
    }

    public Customer has(){
        return customer;
    }


}
