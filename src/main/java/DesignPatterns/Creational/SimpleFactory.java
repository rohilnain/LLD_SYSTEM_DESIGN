package DesignPatterns.Creational;
//Simple factory simply generates an instance for client without exposing any instantiation logic to the client

//case
//Imagine you are building a logging framework that supports different types of logging mechanisms
//such as console logging, file logging, and database logging. Instead of creating objects for each
//logging type manually in different parts of your application, you can use a Simple Factory to handle object creation.


//Why Use Simple Factory?
//Encapsulation: Keeps object creation logic in one place.
//Flexibility: Easy to add new logging mechanisms in the future.
//Decoupling: The client code doesn't need to know which concrete class to instantiate.

// Logger interface
interface Logger {
    void log(String message);
}

// Console Logger
class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("Console Logger: " + message);
    }
}

// File Logger
class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("File Logger: " + message); // Simulating file writing
    }
}

// Database Logger
class DatabaseLogger implements Logger {
    public void log(String message) {
        System.out.println("Database Logger: " + message); // Simulating database logging
    }
}
// Logger Factory
class LoggerFactory {
    public static Logger getLogger(String type) {
        if (type.equalsIgnoreCase("console")) {
            return new ConsoleLogger();
        } else if (type.equalsIgnoreCase("file")) {
            return new FileLogger();
        } else if (type.equalsIgnoreCase("database")) {
            return new DatabaseLogger();
        } else {
            throw new IllegalArgumentException("Unknown Logger Type");
        }
    }
}
public class SimpleFactory {
    public static void main(String []args){
        Logger logger1 = LoggerFactory.getLogger("console");
        logger1.log("Logging to Console!");

        Logger logger2 = LoggerFactory.getLogger("file");
        logger2.log("Logging to File!");

        Logger logger3 = LoggerFactory.getLogger("database");
        logger3.log("Logging to Database!");
    }
}


//When to Use?
//You have multiple related classes implementing a common interface.
//You want to centralize object creation logic for better maintainability.
//The client code should be decoupled from concrete class instantiation.
//Adding new product types (new loggers in this case) should be easy.