package com.example.menu;

import com.example.models.PurchaseFlow;

import java.util.Scanner;

public class CheckoutMenu {
    private final InputHelper input;
    private final PurchaseFlow purchaseFlow;

    public CheckoutMenu(Scanner scanner, PurchaseFlow purchaseFlow) {
        this.input = new InputHelper(scanner);
        this.purchaseFlow = purchaseFlow;
    }

    public void run() {
        purchaseFlow.completePurchase();
    }
}