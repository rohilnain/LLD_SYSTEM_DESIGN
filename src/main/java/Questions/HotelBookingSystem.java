package Questions;

import java.util.Date;
import java.util.List;

public class HotelBookingSystem {
    Address address;
    String name;
    List<Room> roomList;
}
class Address{
    int pin; //zip code
    String city;
    String state;
    String country;
}
class Room{
    String roomId;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog>houseKeepingLogs;
    HouseKeeper houseKeeper;
    RoomType roomType;
    RoomStatus roomStatus;
    Double cost;
}
enum RoomStatus{
    AVAILABLE,BOOKED,RESERVED
}
class RoomKey{
    String Barcode;
    Date issuedAt;
    Boolean isActive;
    Boolean isMaster;
}
enum RoomType{
    DELUXE,NORMAL,EXECUTIVE,KING_SUITE
}
class HouseKeepingLog{
    String Description;
    Date startedAt;
    HouseKeeper houseKeeper;
    void addRoom(Room room){};
}
class Person{
    String Name;
    String Email;
    String Phone;
}
class Receptionist extends Person{
    Search searchObj;
    Book bookObj;
    Account account;
    List<Room>searchAvailableRooms(RoomType roomtype,Location location, Date date,String HotelName){};
    RoomBooking bookRooms(Room room, List<Person>guestList){};
    Boolean cancelRooms(RoomBooking roomBooking){};
    Boolean checkIn(Room room,Customer customer){};
    Boolean checkOut(Room room){};
}
class Admin extends Person{
    Account account;
    void addRoom(Room room){};
    void editRoom(Room room,RoomType updatedRoomType){};
    void deleteRoom(Room room){};
}

class Customer extends Person{
    Search searchObj;
    Book bookObj;

    List<Room>searchAvailableRooms(RoomType roomtype,Location location, Date date,String HotelName){};
    RoomBooking bookRooms(Room room, List<Person>guestList){};
    Boolean cancelRooms(RoomBooking roomBooking){};
}

class HouseKeeper extends Person{
    public List<Room>  getRoomsServiced(Date date){};
}
class Account{
    String userName;
    String Password;
    AccountStatus accountStatus;
}
enum AccountStatus{
    ACTIVE,INACTIVE,BLOCKED
}
class Search{
    List<Room> searchRoom (RoomType roomType,Date date,Location location, String hotelName){};
}
class Book{
    RoomBooking bookRoom(RoomBooking roomBooking){};
    RoomBooking cancelRoom(RoomBooking roomBooking){};
}
class RoomBooking{
    Integer bookingId;
    List<Person>guestList;
    Double totalRoomCharge;
    List<Room>roomList;
    Date startedAt;
    Integer duration;
}

/*Decorator Pattern to calculate total room charges */
enum PaymentType{
    UPI,CREDIT_CARD,DEBIT_CARD,INTERNET_BANKING
}
interface RoomCharge{
    Double getCost();
}
class BasicRoomCharge implements RoomCharge{
    RoomCharge roomCharge;
    BasicRoomCharge(RoomCharge roomCharge){
        this.roomCharge=roomCharge;
    }
    public Double getCost(){
        return 200.02;
    }
}
class DeluxeRoomCharge implements RoomCharge{
    RoomCharge roomCharge;
    DeluxeRoomCharge(RoomCharge roomCharge){
        this.roomCharge=roomCharge;
    }
    public Double getCost(){
        return roomCharge.getCost()+100.02;
    }
}

class RoomServiceCharge implements RoomCharge{
    RoomCharge roomCharge;
    RoomServiceCharge(RoomCharge roomCharge){
        this.roomCharge=roomCharge;
    }
    public Double getCost(){
        return roomCharge.getCost()+50.02;
    }
}

class Location{
    Integer longitude;
    Integer lat;
}