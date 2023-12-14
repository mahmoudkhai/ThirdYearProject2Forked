package uml;

public class Payment {
    public Float Amount;
    private Purchase purchase;

    public Payment(Float amount, Purchase purchase) {
        Amount = amount;
        this.purchase = purchase;
    }
}
