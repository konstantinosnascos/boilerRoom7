package com.example.messages;

import com.example.models.Cart;
import com.example.models.Product;

public class ReceiptPrinter {
    public void printReceipt(Cart cart, double discountApplied, double finalTotal) {
        System.out.println("\n=== KVITTO ===");
        System.out.printf("%-15s %10s\n", "Vara", "Pris (kr)");
        System.out.println("-".repeat(25));
        for (Product product : cart.getItems()) {
            System.out.printf("%-15s %10.2f\n", product.getName(), product.getPrice());
        }
        System.out.println("-".repeat(25));
        System.out.printf("%-15s %10.2f\n", "Summa", cart.getTotal());
        System.out.printf("%-15s %10.2f\n", "Rabatt", discountApplied);
        System.out.printf("%-15s %10.2f\n", "Att betala", finalTotal);
        System.out.println("Tack för ditt köp!");
    }
}