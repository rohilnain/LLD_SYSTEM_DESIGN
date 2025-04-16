package DesignPatterns.Creational;
//The Abstract Factory Pattern is used when you need to create
// families of related objects without specifying their concrete classes.
// It provides an interface for creating related objects and allows flexibility in choosing the actual implementation.


//use
//You are designing a UI framework where components like Buttons and Checkboxes
//need to be created differently based on the operating system (Windows vs. Mac).
//Instead of writing multiple if-else conditions, you can use the Abstract
//Factory Pattern to centralize and abstract object creation.


interface Button{
    void click();
}

interface CheckBox{
    void toggle();
}

class WindowButton implements Button{
    public void click(){
        System.out.println("Window Button is clicked");
    }
}

class MacButton implements Button{
    public void click(){
        System.out.println("Mac Button is clicked");
    }
}

class WindowCheckBox implements CheckBox{
    public void toggle(){
        System.out.println("window checkbox is toggling");
    }
}

class MacCheckBox implements CheckBox{
    public void toggle(){
        System.out.println("Mac Check Box");
    }
}

interface GUIFactory{
    Button createButton();
    CheckBox createCheckBox();
}

// Concrete Factory 1 - Windows Factory
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowButton();
    }
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }

}

// Concrete Factory 2 - Mac Factory
class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }

}

public class AbstractFactory {
    public static void main(String []args){
        GUIFactory factory;

        // Assume we get OS type dynamically
        String osType = "Windows"; // Can be "Mac"

        if (osType.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // Create UI components using the factory
        Button button = factory.createButton();
        CheckBox checkbox = factory.createCheckBox();

        // Render UI components
        button.click();      // Output: Rendering Windows Button
        checkbox.toggle();    // Output: Toggling Windows Checkbox
    }
}
