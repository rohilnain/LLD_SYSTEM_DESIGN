package DesignPatterns.Structural;
//The Decorator Pattern is a structural design pattern that allows you to
// dynamically add new behaviors to objects at runtime without modifying
// their structure.

//Example: Coffee Shop (Adding Add-ons to Coffee)
//Imagine we have different types of coffee, and we want to
// add extra features like milk, ghee,sugar, or caramel without modifying
// the base Coffee class.

//see getCost Method in here
interface Coffee{
    void description();
    double getCost();
}

class SimpleCoffee implements Coffee{
    public void description(){
        System.out.println("Simple Coffee....");
    }
    public double getCost(){
        return 100.20;
    }
}
class MilkCoffee implements Coffee{
    Coffee coffee;
    MilkCoffee(Coffee coffee){
        this.coffee=coffee;
    }
   public  void description(){
        System.out.println("Milk Coffee....");
    }
   public double getCost(){
        return coffee.getCost()+20.40;
   }
}
class GheeCoffee implements Coffee{
    Coffee coffee;
    GheeCoffee(Coffee coffee){
        this.coffee=coffee;
    }
    public void description(){
        System.out.println("Ghee Cofee....");
    }
    public double getCost(){
        return coffee.getCost()+25.20;
    }
}
public class Decorator {
    public static void main(String[]args){
        Coffee simpleCoffee=new SimpleCoffee();
        System.out.println(simpleCoffee.getCost());
        Coffee milkCoffee=new MilkCoffee(simpleCoffee);
        System.out.println(milkCoffee.getCost());
        Coffee GheeCoffee=new MilkCoffee(milkCoffee);
        System.out.println(GheeCoffee.getCost());
    }
}
