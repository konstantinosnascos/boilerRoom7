package com.example;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Produktnamn får inte vara tomt.");
        }
        if (price < 0) {
            System.err.println("Varning: Pris kan inte vara negativt. Sätter pris till 0.0");
            this.price = 0.0;
        } else {
            this.price = price;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + String.format("%.2f", price) + " kr)";
    }
}