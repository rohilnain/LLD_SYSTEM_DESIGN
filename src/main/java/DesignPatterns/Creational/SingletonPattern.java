package DesignPatterns.Creational;
class Singelton{
    private static Singelton instance=null;
    private Singelton(){};
    static Singelton getInstance(){
        if(instance==null){
            instance=new Singelton();
            return instance;
        }
        else return instance;
    }
}
public class SingletonPattern {
    public static void main(String[]args){
        Singelton databaseConnection1=Singelton.getInstance();
        Singelton databaseConnection2=Singelton.getInstance();
        System.out.println(databaseConnection1);
        System.out.println(databaseConnection2);

    }
}

//it is called lazy initialization, though it can run into synchronisation problem with
//multiple thread so when creating singleton instance, we have to make it synchronised
// if(instance==null){
//            synchronized (Singleton.class) {
//                    if (instance == null) { // Double-check
//            instance = new Singleton();
//                            }
//        }
//so now it becomes lazy initialisation + thread safe (efficient and best)


//one is eager implementation of singleton class
//class Singleton {
//    private static final Singleton instance = new Singleton(); // Eager Instantiation
//
//    private Singleton() {} // Private constructor
//
//    public static Singleton getInstance() {
//        return instance;
//    }
//}
//it is best when you always need singleton instance at the start, but if needed
//then it is a wasted instance


//For interview purposes, always mention:
//Lazy initialization + Double-Checked Locking (best for performance).
//Eager initialization (if instance is always required).