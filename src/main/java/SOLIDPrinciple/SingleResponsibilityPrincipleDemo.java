package SOLIDPrinciple;

public class SingleResponsibilityPrincipleDemo {
    //why we should use solid principle
    //    -Avoid code Duplicacy
    //    -Easy to maintain
    //    -Easy to Understand
    //    -Flexible software
    //    -Reduce Complexity


    //1. Single Responsibility Principle
    //A class has only one reason to change

    //let's see problem first

    public class Marker{
        String name;
        String color;
        int price;
        int year;
        Marker(String name,String color,int price,int year){
            this.name=name;
            this.color=color;
            this.price=price;
            this.year=year;
        }
    };

    //this Invoice class has-a (relationship) with marker class

    public class Invoice{
        private Marker marker;
        private Integer quantity;
        Invoice(Marker marker,Integer quantity){
            this.marker=marker;
            this.quantity=quantity;
        }
        public int  calculateTotal(){
            return marker.price*quantity;
        }
        void printInvoice(){
            //handles printing of invoice
        }

        void saveToDB(){
            //handles operation of saving to db
        }
    }

    //Now see above invoice class will change if we change price of marker or something (calculateTotal method)
    //if we change something printInvoice method will also change
    //saveToDB will also change
    //so it is not uploading principle of Single Responsibility, there should be one reason to change

    //how to solve it
    //we can seprate out PrintInvoice class and saveToDB class
    public class Invoice1{
        private Marker marker;
        private Integer quantity;
        Invoice1(Marker marker,Integer quantity){
            this.marker=marker;
            this.quantity=quantity;
        }
        public int  calculateTotal(){
            return marker.price*quantity;
        }
    }

    //Different class which handles print invoice
    public class InvoicePrinter{
        private Invoice1 invoice;
        InvoicePrinter(Invoice1 invoice){
            this.invoice=invoice;
        }
        public void printInvoice(){
            //handles printing of invoice
        }
    }


    // Different class which handles saveToDB invoice
    public class SaveInvoiceDB{
        private Invoice1 invoice;

        SaveInvoiceDB(Invoice1 invoice){
            this.invoice=invoice;
        }

        public void saveToDB(){
            //handles persisting invoice data to DB
        }
    }

    //now it follows single responsibility principle
}
