package com.example;

import com.example.menu.InputHelper;

import java.util.Scanner;

public class ProductMenu {
    private final InputHelper input;
    private final Cart cart;

    public ProductMenu(Scanner input, Cart cart) {
        this.input = new InputHelper(input);
        this.cart = cart;
    }

    public void run() {
        String name = input.getString("Ange produktnamn: ");
        double price = input.getDouble("Ange pris: ");
        Product product = new Product(name, price);
        cart.addItem(product);
        System.out.println(product.getName() + " tillagd till kundvagnen.");
    }
}