package com.example.menu;

import com.example.models.PurchaseFlow;
import com.example.models.Cart;

import java.util.Scanner;

public class MenuHandler {

    private final InputHelper input;
    private final ProductMenu productMenu;
    private final CheckoutMenu checkoutMenu;
    private final ReportMenu reportMenu;

    public MenuHandler(Scanner input, PurchaseFlow purchaseFlow, Cart cart) {
        this.input = new InputHelper(input);
        this.productMenu = new ProductMenu(input, cart);
        this.checkoutMenu = new CheckoutMenu(input, purchaseFlow);
        this.reportMenu = new ReportMenu(input, purchaseFlow);
    }

    public void runMainMenu() {
        boolean running = true;
        while (running) {
            try {
                printMainMenu();
                int choice = input.getInt("Välj ett alternativ: ");
                switch (choice) {
                    case 1 -> productMenu.run();
                    case 2 -> checkoutMenu.run();
                    case 3 -> reportMenu.run();
                    case 4 -> running = false;
                    default -> System.out.println("Felaktigt val, försök igen!");
                }
            } catch (Exception e) {
                System.out.println("Ett oväntat fel uppstod i huvudmenyn: " + e.getMessage());
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n--- Huvudmeny ---");
        System.out.println("1. Lägg till produkter");
        System.out.println("2. Slutför köp");
        System.out.println("3. Visa sammanfattning");
        System.out.println("4. Avsluta programmet");
    }
}