package com.example.models;

import com.example.discounts.DiscountPolicy;
import com.example.messages.NotificationService;
import com.example.messages.ReceiptPrinter;

public class PurchaseFlow {
    private final Cart cart;
    private final DiscountPolicy discountPolicy;
    private final ReceiptPrinter receiptPrinter;
    private final NotificationService notificationService;

    public PurchaseFlow(Cart cart, DiscountPolicy discountPolicy,
                        ReceiptPrinter receiptPrinter,
                        NotificationService notificationService) {
        if (cart == null || discountPolicy == null || receiptPrinter == null || notificationService == null) {
            throw new IllegalArgumentException("Ingen parameter får vara null");
        }
        this.cart = cart;
        this.discountPolicy = discountPolicy;
        this.receiptPrinter = receiptPrinter;
        this.notificationService = notificationService;
    }

    public void addProduct(Product product) {
        cart.addItem(product);
    }

    public void completePurchase() {
        if (cart.isEmpty()) {
            System.err.println("Varning: Kundvagnen är tom. Köp avbryts.");
            return;
        }

        double originalTotal = cart.getTotal();
        double discountedTotal = discountPolicy.applyDiscount(originalTotal);
        double discountAmount = originalTotal - discountedTotal;

        receiptPrinter.printReceipt(cart, discountAmount, discountedTotal);

        String message = String.format(
                "Ditt köp är slutfört. Att betala: %.2f kr. Tack för ditt köp!",
                discountedTotal
        );
        notificationService.notifyCustomer(message);
    }
}