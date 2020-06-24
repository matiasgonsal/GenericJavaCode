package com.mytube;

public class SmsService implements INotificationService{
    public void notify(User user) {
        System.out.println("Notifying by SMS: " + user.getPhoneNumber() + "...");
        System.out.println("Done!\n");
    }
}
