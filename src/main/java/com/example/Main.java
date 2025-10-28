package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        DiscountPolicy policy = new PercentageDiscount(10);
        ReceiptPrinter printer = new ReceiptPrinter();
        NotificationService notifier = new NotificationService();
        notifier.setSender(new EmailSender());

        PurchaseFlow purchaseFlow = new PurchaseFlow(cart, policy, printer, notifier);

        MenuHandler menuHandler = new MenuHandler(scanner, purchaseFlow, cart);
        menuHandler.runMainMenu();

        scanner.close();
    }
}