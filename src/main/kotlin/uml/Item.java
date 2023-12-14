package uml;

public class Item {
    public String name;
    public Integer itemId;
    public Float weight;
    public String manufacturer;
    private ShoppingCart shoppingCart;

    public Item(String name, Integer itemId, Float weight, String manufacturer) {
        this.name = name;
        this.itemId = itemId;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
