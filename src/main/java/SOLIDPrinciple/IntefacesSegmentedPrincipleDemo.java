package SOLIDPrinciple;

//Interfaces Segmented Principle
public class IntefacesSegmentedPrincipleDemo {
    //4. Interfaces should be such,that client should not implement unnecessary functions they do not need

    interface RestaurantEmployee{
        void washDishes();
        void serveCustomers();
        void cookFood();
    }

    class waiter implements RestaurantEmployee{

        @Override
        public void washDishes() {
            //not my duty
        }

        @Override
        public void serveCustomers() {
            //my duty
        }

        @Override
        public void cookFood() {
            //not my duty
        }

        //so problem here is waiter class have to implement the methods which actually it does not need
        //redundant and not useful methods, also not methods of waiter class
    }

    //better way to do it, separate the interface of waiter, chef and dishWasher
    //so that interface can be segmented

    //waiter interface
    interface WaiterInterface{
        void serveCustomers();
    }

    //dish washer interface
    interface DishWasherInterface{
        void dishWasher();
    }

    //chef interface
    interface ChefInterface{
        void cookFood();
    }

}
