package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        if (product != null) {
            items.add(product);
        }
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return new ArrayList<>(items); // skydd mot mutering
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", total=" + String.format("%.2f", getTotal()) + " kr" +
                '}';
    }
}