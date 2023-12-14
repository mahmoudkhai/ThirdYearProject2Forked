package uml;

public class SalesPerson {
    public String name;
    public Integer id;
    public ShoppingMall worksAt;

    public SalesPerson(String name, Integer id, ShoppingMall worksAt) {
        this.name = name;
        this.id = id;
        this.worksAt = worksAt;
    }

    public ShoppingMall getWorksAt() {
        return worksAt;
    }

    public void helps(Customer customer) {

    }
}
