package com.example;

public class FixedAmountDiscount implements DiscountPolicy {
    private final double discountAmount;

    public FixedAmountDiscount(double discountAmount) {
        if (discountAmount < 0) {
            System.err.println("Varning: Rabattbelopp får inte vara negativt. Sätter till 0.0");
            this.discountAmount = 0.0;
        } else {
            this.discountAmount = discountAmount;
        }
    }

    @Override
    public double applyDiscount(double total) {
        return Math.max(0, total - discountAmount); // total kan inte bli negativ
    }
}