package DesignPatterns.Structural;
//The Composite Design Pattern is a structural pattern that allows
// treating individual objects and compositions of objects uniformly.
//It is particularly useful when dealing with hierarchical tree structures
// (e.g., file systems, UI elements, organizational structures).

//use case
//Imagine we are building a Company Employee Management System where:
//Employees can be Managers or Developers.
//Managers can have subordinates (other Developers or Managers).
//We should be able to treat individual employees and groups of employees in the same way.

//Issues Without Composite Pattern
//Without using the Composite Pattern, we would need separate methods
//for handling a single employee vs. a group of employees, leading to
//code duplication and complexity.

import java.util.ArrayList;
import java.util.List;

interface Employee{
    void showDetail();
}

class Developer implements Employee{
    String name;
    String position;
    Developer(String name,String position){
        this.name=name;
        this.position=position;
    }
    public void showDetail(){
        System.out.println("Developer name is "+name+" and position is "+position);
    }
}

class Manager implements Employee{
    String name;
    String position;
    List<Employee> subordinates=new ArrayList<>();
    Manager(String name, String position){
        this.name=name;
        this.position=position;
    }
    public void showDetail(){
        System.out.println("Manager name is "+name+" position is "+position);
    }
    public void addEmployee(Employee employee){
        subordinates.add(employee);
    }
    public void removeEmployee(Employee employee){
        subordinates.remove(employee);
    }
    public void showSubordinates(){
        for(Employee employee:subordinates){
            employee.showDetail();
        }
    }

}
public class Composite {
    public static void main(String[]args){
        System.out.println("I am inside Composite Design Pattern");
        Employee developer1=new Developer("Rohil","Senior Member Technical Staff");
        Employee developer2=new Developer("Akash","Member Technical Staff");
        Manager manager1=new Manager("Madhur Bhatia"," Director of Engineering");
        Manager manager2=new Manager("Yogesh","Techical Lead");
        manager2.addEmployee(developer2);
        manager2.addEmployee(developer1);
        manager1.addEmployee(manager2);
        manager2.showSubordinates();
    }
}

//When to Use the Composite Pattern?
//When dealing with tree structures (e.g., file systems, UI components, organization hierarchies).
//When you need to treat individual and composite objects uniformly.
//When you want to avoid complex if-else conditions for different object types.
