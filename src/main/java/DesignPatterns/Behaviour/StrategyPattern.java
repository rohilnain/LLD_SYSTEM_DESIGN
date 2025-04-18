package DesignPatterns.Behaviour;
//The Strategy Pattern is a behavioral design pattern that lets you define
// a family of algorithms, encapsulate them into separate classes, and
// make them interchangeable at runtime.

//When to Use the Strategy Pattern?
//When you have multiple variations of an algorithm (e.g., different sorting strategies).
//When you want to switch behaviors dynamically at runtime.
//When you want to avoid multiple if-else or switch-case statements.

//Example: Payment System (UPI, Credit Card, PayPal)
//Imagine an e-commerce system where users can pay using different payment methods:
//UPI Payment
//Credit Card Payment
//PayPal Payment
//Instead of hardcoding all these payment methods in a single class,
// we use Strategy Pattern to make the payment method interchangeable dynamically.

interface PaymentStrategy{
    void pay(int amount);
}

class UPIPayment implements PaymentStrategy{
    String upiId;
    UPIPayment(String upiId){
        this.upiId=upiId;
    }
    public void pay(int amount){
        System.out.println(amount+" is Paid through paytm, upi id is "+upiId);
    }
}

class CreditCardPayment implements PaymentStrategy{
    String creditCardNumber;
    CreditCardPayment(String creditCardNumber){
        this.creditCardNumber=creditCardNumber;
    }
    public void pay(int amount){
        System.out.println(amount+ " is paid by Credit Card, Credit Card Number is "+creditCardNumber);

    }
}

class OnlineShopping{
    PaymentStrategy paymentStrategy;
    OnlineShopping(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public void payAmount(int amount){
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void  main (String[]args){
        UPIPayment paytmPayment=new UPIPayment("9876543210");
        CreditCardPayment amexCreditCard=new CreditCardPayment("1234567890");
        OnlineShopping amazonShopping=new OnlineShopping(paytmPayment);
        amazonShopping.payAmount(250);
    }

}

//Benefits of Strategy Pattern
//Removes if-else conditions → No need for long if-else chains for different strategies.
//Allows runtime selection → The algorithm can be changed dynamically.
//Promotes Open-Closed Principle → New strategies can be added without modifying existing code.
//Improves maintainability → Each strategy is in its own class, making the code more modular.

//Common Use Cases
//Sorting Algorithms (Merge Sort, Quick Sort, Bubble Sort)
//Compression Strategies (ZIP, RAR, GZIP)
//Payment Gateways (Credit Card, PayPal, UPI)
// File Saving Formats (PDF, CSV, JSON)