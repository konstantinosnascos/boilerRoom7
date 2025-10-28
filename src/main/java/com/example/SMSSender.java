package com.example;

public class SMSSender implements MessageSender {
    private String phoneNumber = "+46701234567"; // Exempel

    @Override
    public void send(String message) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            System.err.println("Varning: Inget telefonnummer angivet. SMS ej skickat.");
            return;
        }
        System.out.println("Skickar SMS till " + phoneNumber + ":");
        System.out.println("[SMS] " + message);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}