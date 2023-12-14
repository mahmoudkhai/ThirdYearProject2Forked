package uml;

public class Customer {
    public String name;
    private ShoppingMall shoppingMall;

    public Customer(String name) {
        this.name = name;
    }

    public void enters(ShoppingMall shoppingMall) {
        this.shoppingMall = shoppingMall;
    }



}
