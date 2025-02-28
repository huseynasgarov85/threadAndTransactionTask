package banking.model;

import java.io.Serializable;

public class Card implements Serializable {
    private String pan;
    private double amount;

    public Card(String pan, double amount) {
        this.pan = pan;
        this.amount = amount;
    }

    public String getPan() {
        return pan;
    }
    public void setPan(String pan) {
        this.pan = pan;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Card{" +
                "pan='" + pan + '\'' +
                ", amount=" + amount +
                '}';
    }
}
