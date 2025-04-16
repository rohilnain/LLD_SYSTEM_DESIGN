package DesignPatterns.Behaviour;
import java.util.ArrayList;
import java.util.List;

//The Observer Pattern is a behavioral design pattern used to define
// a one-to-many relationship between objects. When the state of one
// object changes, all its dependents (observers) are notified and updated automatically.

//Key Concept
//Subject (Publisher): The object that maintains the state and notifies observers of any state changes.
//Observer: The object that receives updates when the subject's state changes.
//Loose Coupling: The subject does not need to know the specifics of its observers,just that they implement the Observer interface.

//When to Use Observer Pattern
//When you have a one-to-many relationship between objects (e.g., a newsletter subscription system).
//When you need to notify all dependent objects automatically when the state of a subject changes.

interface Observer{
    void update(String message);
}

interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

//making concrete subject classes
class NewsChannel implements Subject{
    List<Observer>observers=new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(String message) {
        for(Observer observer:observers){
            observer.update(message);
        }
    }
    public void broadcastNews(String message){
        System.out.println("Broadcasting news");
        notifyObservers(message);
    }
}

//observers listening to subject (new channel)
class Client implements Observer{
    public void update(String message){
        System.out.println(message);
    }
}
public class ObserverPattern {
    public static void main(String []args){
        System.out.println("i am inside observer pattern");
        NewsChannel newsChannel=new NewsChannel();
        Client client1=new Client();
        Client client2=new Client();
        newsChannel.addObserver(client1);
        newsChannel.addObserver(client2);
        newsChannel.broadcastNews("Broadcasting fatafat news from aajtak");
    }
}


//How It Works:
//Subject (NewsChannel) maintains a list of observers (users).
//When the subject broadcasts a message (broadcastNews()), it notifies all observers (subscribed users).
//Observers (User) implement the update() method, which is called to receive updates.
//Observers can be added or removed dynamically from the subject.


//Common Use Cases:
//Event-driven systems (e.g., UI Event Handlers)
//Real-time notifications (e.g., Social Media feeds, News subscriptions)
//Model-View-Controller (MVC) architecture (where views update automatically when the model changes)
//Logging systems (where different modules can log to a central logger)