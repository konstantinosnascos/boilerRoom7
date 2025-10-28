package com.example;

public class NotificationService {
    private MessageSender sender;

    public void setSender(MessageSender sender) {
        if (sender == null) {
            throw new IllegalArgumentException("MessageSender får inte vara null");
        }
        this.sender = sender;
    }

    public void notifyCustomer(String message) {
        if (sender == null) {
            System.err.println("Varning: Ingen meddelandekanal konfigurerad. Kan inte skicka meddelande.");
            return;
        }
        sender.send(message);
    }
}