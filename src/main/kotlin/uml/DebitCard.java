package uml;

import java.util.Date;

public class DebitCard extends Payment {
    public Integer cardNumber;
    public Date dateOfExpiry;

    public DebitCard(Float amount, Purchase purchase, Integer cardNumber, Date dateOfExpiry) {
        super(amount, purchase);
        this.cardNumber = cardNumber;
        this.dateOfExpiry = dateOfExpiry;
    }
}
