package DesignPatterns.Structural;
//The Adapter Pattern is used when two incompatible interfaces need to work together.
// It acts as a bridge between different interfaces, allowing them to communicate
// without modifying their existing code. - like adapter make memory card being readable to computer

//use case
//Imagine a Hunter class that hunts Lions. The Hunter class expects a Lion object,
// but now we want to introduce a Wild Dog into the system. The problem is:
//Hunter expects a Lion, but WildDog is not a Lion.
//WildDog has a different interface (bark() instead of roar()).
//To solve this, we use the Adapter Pattern (WildDogAdapter) to make WildDog
// compatible with Hunter.

interface Lion{
    void roar();

}
class AfricanLion implements Lion{
    public void roar(){
        System.out.println("African Lion is roaring");
    }
}
class Hunter{
   public  void hunt(Lion lion){
        lion.roar();
    }
}

class WildDog{
    void bark(){
        System.out.println("WildDog is barking");
    }
}

class WildDogAdapter implements Lion{
    WildDog wildDog;
    WildDogAdapter(WildDog wildDog){
        this.wildDog=wildDog;
    }
    public void roar(){
        wildDog.bark();
    }
}
public class Adapter {
    public static void main(String []args){
        System.out.println("I am inside Adapter Design Pattern");
        WildDog dog=new WildDog();
        WildDogAdapter wildDogAdapter=new WildDogAdapter(dog);
        Lion lion=new AfricanLion();
        Hunter hunter= new Hunter();
        hunter.hunt(wildDogAdapter);
        hunter.hunt(lion);
    }
}


//Real-World Examples
//Database Drivers: Java’s JDBC drivers act as adapters between different databases (MySQL, PostgreSQL) and Java’s Connection interface.
//Spring Boot Converters: Spring MVC uses Converter and Adapter to convert data types between requests and responses.
//Payment Gateway Integration: A payment gateway like Stripe or PayPal may have a different API, requiring an adapter to match your system's expected format.