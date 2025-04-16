package DesignPatterns.Creational;
//When to Use Factory Method Pattern?
//When object creation needs to be delegated to subclasses instead of being handled by a single factory class.
//When you need a flexible, extendable design that allows new product types to be introduced without modifying existing code.
//When the exact type of object to be created is determined at runtime.


//use case
//Imagine a Notification System that supports different notification types like Email, SMS, and Push Notifications.
//Instead of using a simple factory, we want each subclass to define its own way of creating objects, making it easy to extend in the future.


interface Notification{
    public void notifyUser();
}

class SMSNotification implements  Notification{
    public void notifyUser(){
        System.out.println("SMS Notification.....");
    }
}
class EmailNotification implements Notification{
    public void notifyUser(){
        System.out.println("Email Notification......");
    }
}

class PushNotification implements Notification{
    public void notifyUser(){
        System.out.println("Push Notification .........");
    }
}

abstract class NotificationFactory{
    abstract Notification createNotification();

    public void sendNotification(){
        Notification notification=createNotification();
        notification.notifyUser();
    }

}

class SMSNotificationFactory extends NotificationFactory{

    @Override
    Notification createNotification() {
        return new SMSNotification();
    }
}

class EmailNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new EmailNotification();
    }
}

class PushNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new PushNotification();
    }
}
public class FactoryMethod {
    public static void main(String[] args){
        NotificationFactory factory1 = new EmailNotificationFactory();
        factory1.sendNotification();  // Output: Sending Email Notification...

        NotificationFactory factory2 = new SMSNotificationFactory();
        factory2.sendNotification();  // Output: Sending SMS Notification...

        NotificationFactory factory3=new PushNotificationFactory();
        factory3.sendNotification();
    }
}



//why not simple factory
//Problem with Simple Factory
//Hard to Extend: If we add a new notification type (lets say Alert Notification), we must modify NotificationFactory, which violates Open-Closed Principle.
//Factory Gets Bloated: The factory will keep growing as more notification types are added.

//In Factory Method, object creation is delegated to subclasses, making it easy to add new types without modifying existing code.
//With Factory Method, adding Alert Notification is easy!
//We don’t modify existing classes, we just add a new factory and new subclass of AlertNotification