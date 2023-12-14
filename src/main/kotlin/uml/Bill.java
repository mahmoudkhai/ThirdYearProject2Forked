package uml;

import java.util.Date;

public class Bill {
    public Date date;
    public Float amount;
    private Purchase purchase;
    private Receipt receipt;

    public Bill(Date date, Float amount, Purchase purchase, Receipt receipt) {
        this.date = date;
        this.amount = amount;
        this.purchase = purchase;
        this.receipt = receipt;
    }
}
