package Questions;

import java.util.Date;
import java.util.List;
public class ParkingLot {
    Address address;
    List<Floor>floors;
    List<Attendant>attendantList;
    List<Gate>gates;

    void addFloor(Floor floor){};
    void deleteFloor(Floor floor){};

    void AssignAttendantToGate(Gate gate,Attendant attendant){};
}

class Floor{
    int floorNumber;
    List<ParkingSpot>parkingSpotList;
    DisplayBoard displayBoard;

    void addParkingSpot(ParkingSpot parkingSpot){};
    void removeParkingSpot(ParkingSpot parkingSpot){};
    void editParkingSpot(ParkingSpot parkingSpot){};


}

class Gate{
    int gateId;
    Attendant attendant;
}
class EntryGate extends Gate{
    List<Floor> floor;
    Ticket processEntryTicket(Vehicle vehicle){

    }
    List<ParkingSpot>getAvailableSpots(Floor floor,ParkingSpotType parkingSpotType){};
}
class ExitGate extends Gate{
    PaymentStartegy paymentStartegy;
    Boolean processPayment(Ticket ticket,PaymentMode paymentMode){
        if(paymentMode==PaymentMode.CASH){
            paymentStartegy=new CashPaymentStrategy();
        }
        if(paymentMode==PaymentMode.UPI){
            paymentStartegy=new UPIPaymentStrategy();
        }
        if(paymentMode==PaymentMode.CREDIT_CARD){
            paymentStartegy=new CreditCardPaymentStrategy();
        }
        //....
    }
}
class ParkingSpot{
    Location location;
    ParkingSpotType parkingSpotType;
    Double parkingSpotCharge;
}
class Location{
    ZoneType zoneType;
    int spotNumber;
}
enum ZoneType{
    GREEN,YELLOW,PINK,RED
}
enum ParkingSpotType{
    TWO_WHEELER,FOUR_WHEELER_LIGHT,FOUR_WHEELER_HEAVY
}
class Vehicle{
    String vehicleNumber;
    VehicleType vehicleType;
}
enum VehicleType{
    TWO_WHEELER,FOUR_WHEELER_LIGHT,FOUR_WHEELER_HEAVY
}
class Attendant{
    String userName;
    String Password;
    String Email;
    String Name;
}

class DisplayBoard{
    int displayBoardId;
     void DisplayVacantParkingSpots(List<ParkingSpot>availableParkingSpots){};
}

class Ticket{
    Floor floor;
    Attendant attendant;
    Date entryTime;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    Double charges;
}

enum PaymentMode{
    CASH,UPI,CREDIT_CARD
}
interface PaymentStartegy{
    void pay(Double amount);
}

class CashPaymentStrategy implements PaymentStartegy{
    public void pay(Double amount){

    }
}
class UPIPaymentStrategy implements PaymentStartegy{
    public void pay(Double amount){

    }
}
class CreditCardPaymentStrategy implements PaymentStartegy{
    public void pay(Double amount){

    }
}