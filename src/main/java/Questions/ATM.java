package Questions;

import java.util.Date;

public class ATM {
    Address address;
    CashDispenser cashDispenser;
    CashDepositor cashDepositor;
    CardSwiper cardSwiper;
    Screen screen;
    BankRegistrationDetail bankRegistrationDetail;
}
class Address{
    int pin;//zipcode
    String city;
    String state;
    String country;
}

class CashDispenser{
    Integer dispenseCash{Integer requestedCashAmount}{
    }
}
class CashDepositor{
    Boolean depsitCash(Integer amountDeposited){

    }
}
class CardSwiper{
    CardDetails readCard(CardDetails card){

    }
}
class Screen{
    CashDispenser cashDispenser;
    CashDepositor cashDepositor;
    CardSwiper cardSwiper;
    Integer checkUserBalance(CardDetails cardDetails, String passcode){};
    Boolean depositUserCash(CardDetails card,String Passcode,Integer amountToBeDeposited){};
    Integer withdrawFunds(CardDetails card,String Passcode,Integer amountToWithdraw){};
    Boolean transferFunds(CardDetails card,String Passcode,Integer fundsToTransfer, BankDetails recieverbankDetails){};
}
class CardDetails{
    String accountNumber;
    String cardNumber;
    String CVV;
    CardType cardType;
    Date expiryDate;
    String userName;
    CardStatus cardStatus;
}
enum CardType{
    VISA,MASTERCARD,RUPAY
}
enum CardStatus{
    ACTIVE,INACTIVE,BLOCKED
}
class BankDetails{
    String accountNumber;
    String IFSCCode;
    String name;
    String bankName;
}
class BankRegistrationDetail{
    Integer atmId;
    String bankName;
    Integer RegistrationId;
}