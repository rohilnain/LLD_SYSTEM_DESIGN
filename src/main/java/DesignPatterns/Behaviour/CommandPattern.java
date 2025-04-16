package DesignPatterns.Behaviour;

//It encapsulates a request as an object. It allows decoupling of the sender
// (Invoker) from the receiver (the object that performs the action).

//Key Concept
//Encapsulates requests as objects.
//Supports undo/redo operations.
//Decouples the sender and receiver, allowing more flexible system design.

//When to Use the Command Pattern?
//When you need to queue, log, or undo operations.
//When you want to decouple the sender from the receiver.
//When commands need to be executed at a later time (e.g., Job scheduling).
//When implementing Macro commands (multiple actions triggered at once).


//Imagine a button  that can:
//Turn ON and OFF a Light
//Turn ON and OFF a Fan

interface Command{
    void execute();
    void undo(); //Support undo functionality
}

class Light{
    void turnOn(){
        System.out.println("Light is turned on");
    }
    void turnOff(){
        System.out.println("Light is turned Off");
    }
}

class Fan{
    void turnOn(){
        System.out.println("Fan is turned on");
    }
    void turnOff(){
        System.out.println("Fan is turned Off");
    }
}

//now make command for these concrete classes to abstract them

class LightOnCommand implements Command{
    Light light;
    LightOnCommand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// Concrete Command: Turn OFF the Light
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Concrete Command: Turn ON the Fan
class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }
}

// Concrete Command: Turn OFF the Fan
class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOn();
    }
}

class Button {
    Command command;
    Button(Command command){
        this.command=command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}
public class CommandPattern {
    public static void  main(String []args){
        Light light=new Light();
        Command lightOnCommand=new LightOnCommand(light);
        Button lightonoffbutton=new Button(lightOnCommand);
        lightonoffbutton.pressButton();
        lightonoffbutton.pressUndo();

    }
}


//How It Works
//The Receiver (Light, Fan) performs the actual work.
//The Concrete Command Classes (LightOnCommand, FanOffCommand)
// //encapsulate these operations.
//The Invoker (RemoteControl) calls execute() and undo()
//without knowing implementation details.
//The Client (CommandPatternDemo) sets commands dynamically.


//Common Use Cases
//Undo/Redo operations (Text Editors, IDEs, Photoshop)
//Macro recording (Automate repetitive tasks by recording commands)
//Job Scheduling Systems
//GUI buttons and menu actions (e.g., File → Save, File → Open)
//Home Automation (Smart Home Controls)