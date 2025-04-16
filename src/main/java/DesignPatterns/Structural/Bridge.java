package DesignPatterns.Structural;
//The Bridge Pattern is used to decouple an abstraction from its implementation,
// allowing both to evolve independently. It helps avoid inheritance explosion
// when multiple implementations and variations are involved.

//use case
//Imagine you are designing a Remote Control System for different types of Devices (TV, Radio, etc.).
//Instead of having separate classes for TVRemote, RadioRemote, etc., we will bridge the abstraction (RemoteControl) with the implementation (Device).
//This allows us to add new devices and remotes independently without modifying existing code.

//how explosion can occur ....if we have 2 type of remote control....advanced remote control (mute sound) and normal remote
//so if we have devices like radio, tv...then there would be 4 variations of remoteControlTV, remoteControlRadio,advanceRemoteControlTV,advanceRemoteControlRadio
//so if we add more remote control system and more devices so more explosion will happen

import javax.swing.plaf.basic.BasicBorders;

interface Device{
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

//writing implementation code (Device Code)
class TV implements Device{
    private int volume=10;
    public void turnOn(){
        System.out.println("TV has been turned On");
    }
    public void turnOff(){
        System.out.println("TV has been Turned Off");
    }
    public void setVolume(int volume){
        this.volume=volume;
        System.out.println("volume is set to: "+volume);
    }
}
class Radio implements Device{
    private int volume=20;
    public void turnOn(){
        System.out.println("Turning On the Radio");
    }
    public void turnOff(){
        System.out.println("Turning off the Radio");
    }
    public void setVolume(int volume){
        this.volume=volume;
    }
}

//now writing abstraction code (Remote Control)

class RemoteControl {
    Device device;//so this act as bridge, composition over inheritance is prefered

    RemoteControl(Device device){
        this.device=device;
    }
    public void turnOn(){
        device.turnOn();
    }
    public void turnOff(){
        device.turnOff();
    }
    public void setVolume(int volume){
        device.setVolume(volume);
    }
}

//let's say we want to extend Remote Control to advance remote control that mutes the device
//So advance remote control will have all functionality of remote control + mute...others
class AdvanceRemoteControl extends RemoteControl{
    AdvanceRemoteControl(Device device){
        super(device);
    }
    void mute(){
        device.setVolume(0);
    }
}
public class Bridge {
    public static void  main(String []args){
        System.out.println("I am inside Bridge Pattern");
        TV tv=new TV();
        Radio radio=new Radio();
        RemoteControl tvRemoteControl=new RemoteControl(tv);
        RemoteControl radioRemoteControl=new RemoteControl(radio);

        tvRemoteControl.turnOn();
        tvRemoteControl.setVolume(40);
        radioRemoteControl.turnOn();

        AdvanceRemoteControl advanceRemoteControlTV=new AdvanceRemoteControl(tv);
        advanceRemoteControlTV.mute();


    }
}


//When to Use Bridge Pattern?
//When you want to separate abstraction from implementation.
//When you expect multiple variations of abstraction and implementation (e.g., different remotes and devices).
//When new functionalities should be added independently.

//Real-World Examples

//Payment Processing System:
//PaymentProcessor (Abstraction) → CreditCardProcessor, PayPalProcessor
//PaymentGateway (Implementation) → Stripe, Razorpay

//Database Drivers (JDBC in Java):
//DatabaseConnection (Abstraction) → MySQLConnection, PostgreSQLConnection
//JDBC Driver (Implementation) → Connects to various databases