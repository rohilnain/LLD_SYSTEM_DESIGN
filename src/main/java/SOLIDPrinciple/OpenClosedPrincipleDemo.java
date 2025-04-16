package SOLIDPrinciple;

public class OpenClosedPrincipleDemo {

    //2. lets see what "O" stands for (Open/Closed Principle)
    //it is for Open for Extension but closed for modification

    //lets see problem first then
    public class Invoice1{
        private SingleResponsibilityPrincipleDemo.Marker marker;
        private Integer quantity;
        Invoice1(SingleResponsibilityPrincipleDemo.Marker marker, Integer quantity){
            this.marker=marker;
            this.quantity=quantity;
        }
        public int  calculateTotal(){
            return marker.price*quantity;
        }
    }

    //Different class which handles print invoice
    public class InvoicePrinter{
        private SingleResponsibilityPrincipleDemo.Invoice1 invoice;
        InvoicePrinter(SingleResponsibilityPrincipleDemo.Invoice1 invoice){
            this.invoice=invoice;
        }
        public void printInvoice(){
            //handles printing of invoice
        }
    }


    public class SaveInvoiceDB{
        private Invoice1 invoice;

        SaveInvoiceDB(Invoice1 invoice){
            this.invoice=invoice;
        }

        public void saveToDB(){
            //handles persisting invoice data to DB
        }
        public void saveToFIle(){
            //handles persisting invoice data to Fle
        }
    }
    //so we have added a saveToFile Method to our previously tested class SaveInvoiceDB
    // so it has modified this class, which is safely tested and deployed
    // so it goes against the principle of open for extension but closed for modification

    //so this is how it done
    interface SaveInvoice{
        public void save(Invoice1 invoice);
    }

    //now writing logic for SaveInvoiceDB class implementing this inteface
    public class SaveInvoiceDB1 implements SaveInvoice{
        private Invoice1 invoice;
        SaveInvoiceDB1(Invoice1 invoice){
            this.invoice=invoice;
        }

        @Override
        public void save(Invoice1 invoice) {
            //handling saving to DB
        }
    }

    //now writing logic for SaveInvoiceFile class implementing this inteface
    public class SaveInvoiceFile implements SaveInvoice{
        private Invoice1 invoice;
        SaveInvoiceFile(Invoice1 invoice){
            this.invoice=invoice;
        }

        @Override
        public void save(Invoice1 invoice) {
            //handling saving to FIle
        }
    }

    //so it is following Open for extension but not modification principle
}
