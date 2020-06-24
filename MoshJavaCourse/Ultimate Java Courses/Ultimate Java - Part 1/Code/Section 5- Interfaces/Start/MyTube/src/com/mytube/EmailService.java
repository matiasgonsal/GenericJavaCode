package com.mytube;

public class EmailService implements INotificationService {
    public void notify(User user) {
        System.out.println("Notifying by Email: " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
