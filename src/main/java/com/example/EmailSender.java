package com.example;

public class EmailSender implements MessageSender {
    private String emailAddress = "kund@example.com"; // Kan utökas till konfiguration

    @Override
    public void send(String message) {
        if (emailAddress == null || emailAddress.trim().isEmpty()) {
            System.err.println("Varning: Ingen e-postadress angiven. Meddelande ej skickat.");
            return;
        }
        System.out.println("Skickar e-post till " + emailAddress + ":");
        System.out.println("[EMAIL] " + message);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}