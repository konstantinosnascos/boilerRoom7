package com.example;

import com.example.menu.InputHelper;

import java.util.Scanner;

public class ReportMenu {
    private final InputHelper input;
    private final PurchaseFlow purchaseFlow;

    public ReportMenu(Scanner input, PurchaseFlow purchaseFlow) {
        this.input = new InputHelper(input);
        this.purchaseFlow = purchaseFlow;
    }

    public void run() {
        // Enkel sammanfattning – kan byggas ut
        System.out.println("\n--- Sammanfattning ---");
        // Eftersom vi inte håller direkt referens till cart här, använd reflexivt via completePurchase logik
        System.out.println("Kundvagnens innehåll och totalsummor visas vid köp.");
        System.out.println("Använd 'Slutför köp' för att se full rapport.");
    }
}