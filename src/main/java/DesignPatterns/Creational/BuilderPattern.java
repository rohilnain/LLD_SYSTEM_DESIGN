package DesignPatterns.Creational;
//The Builder Pattern is a creational design pattern used to construct
// complex objects step by step. Instead of having a large constructor
// with multiple parameters, we use a separate builder class that
// provides chained methods to set values.

//When to Use the Builder Pattern?
//When an object has many optional parameters.
//When you want to make object creation readable and flexible.
//When you want to avoid telescoping constructors (multiple constructors with different parameters).

//use case
//Imagine we have a User class with optional fields like phone number,
// address, and email. Instead of creating multiple constructors, we use a Builder.

//user class is nested class, builder class is also within it and it can
//access builder private member
class User{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private User(UserBuilder userBuilder){
        this.firstName=userBuilder.firstName;
        this.lastName=userBuilder.lastName;
        this.email=userBuilder.email;
        this.phone=userBuilder.phone;
        this.address=userBuilder.address;
    }
    public String toString(){
        return "user, first name is: "+firstName
                +" last name is: "+lastName
                +" email is:"+email
                +" phone is:"+phone
                +" address is:"+address;
    }
    public  static class UserBuilder{
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;

        UserBuilder(String firstName,String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
        }
        public UserBuilder setEmail(String email){
            this.email=email;
            return this;
        }
        public UserBuilder setPhone(String phone){
            this.phone=phone;
            return this;
        }
        public UserBuilder setAddress(String address){
            this.address=address;
            return this;
        }
        User build(){
            return new User(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[]args){
        User user1=new User.UserBuilder("Rohil","Nain")
                .setEmail("rohilnain1999@gmail.com")
                .setPhone("8851453871")
                .build();
        System.out.println(user1.toString());
        User user2=new User.UserBuilder("Rohit","Dhama")
                .setEmail("rohit1999@gmail.com")
                .build();
        System.out.println(user2.toString());
    }
}


//Key Takeaways
//Use the Builder Pattern when an object has many optional parameters.
//Ensures immutability & makes object creation clean and flexible.
//Avoids multiple constructors with different parameter lists.