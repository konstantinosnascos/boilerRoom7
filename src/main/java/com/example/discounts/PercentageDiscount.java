package com.example.discounts;

public class PercentageDiscount implements DiscountPolicy {
    private final double discountPercent;

    public PercentageDiscount(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            System.err.println("Varning: Ogiltig rabattprocent. Använder 0%");
            this.discountPercent = 0;
        } else {
            this.discountPercent = discountPercent;
        }
    }

    @Override
    public double applyDiscount(double total) {
        return total * (1 - discountPercent / 100);
    }
}