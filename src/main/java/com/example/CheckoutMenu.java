package com.example;

import com.example.menu.InputHelper;

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