package SOLIDPrinciple;

public class LiskovSubstitutionPrincipleDemo {

    //3. Liskov Substitution Principle
    // If class B is a subclass of class A, then we should be able to
    // replace object of A with B without breaking the behaviour of program

    //lets see problem scenerio
    public interface Vehicle{
        void turnOnEngine();
        void accelerate();
    }

    public static class Motorcycle implements Vehicle{
        boolean isEngineOn;
        int speed;

        @Override
        public void turnOnEngine() {
            isEngineOn=true;
        }

        @Override
        public void accelerate() {
            speed=speed+10;
        }
    }

    public static  class Bicycle implements Vehicle{
        boolean isEngineOn;
        int speed;

        @Override
        public void turnOnEngine() {
            throw new AssertionError("there is no engine");
        }

        @Override
        public void accelerate() {
            speed=speed+10;
        }
    }

    public static void main(String[] args) {
        //now lets see
        Vehicle vehicle1= new Bicycle();
        Vehicle vehicle2= new Motorcycle();
        turnEngine(vehicle1);
        turnEngine(vehicle2);

    }

    public static void  turnEngine(Vehicle vehicle){
        vehicle.turnOnEngine();
        //so here liskov principle fails because when bicycle object is passed
        //it will throw error as it does have any engine, so parent interface property is destroyed
        //so we should not do that

        //solution:rather we can make different interface for motorbike( engine based bike) and for bicycle (non-engine based vehicle)
    }
}
