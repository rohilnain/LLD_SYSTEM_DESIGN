package Questions;

import java.util.Date;

public class ATMSystem_FULL {

    // ----------- MAIN ATM CLASS -----------
    static class ATM {
        private final Address address;
        private final CashDispenser cashDispenser;
        private final CashDepositor cashDepositor;
        private final CardSwiper cardSwiper;
        private final Screen screen;
        private final ATMService atmService;
        private final BankRegistrationDetail registrationDetail;

        public ATM(Address address, BankRegistrationDetail registrationDetail) {
            this.address = address;
            this.registrationDetail = registrationDetail;
            this.cashDispenser = new CashDispenser();
            this.cashDepositor = new CashDepositor();
            this.cardSwiper = new CardSwiper();
            this.screen = new Screen();
            this.atmService = new ATMService(cashDispenser);
        }

        public void startATM(CardDetails card, String pin) {
            cardSwiper.readCard(card);
            if (atmService.authenticate(card, pin)) {
                screen.showMenu(card, atmService, pin, cashDepositor);
            } else {
                System.out.println("Authentication failed.");
            }
        }
    }

    // ----------- SUPPORT CLASSES -----------
    static class Address {
        int pin;
        String city;
        String state;
        String country;
    }

    static class BankRegistrationDetail {
        Integer atmId;
        String bankName;
        Integer registrationId;
    }

    static class CardDetails {
        String accountNumber;
        String cardNumber;
        String CVV;
        CardType cardType;
        Date expiryDate;
        String userName;
        CardStatus cardStatus;
    }

    enum CardType {
        VISA, MASTERCARD, RUPAY
    }

    enum CardStatus {
        ACTIVE, INACTIVE, BLOCKED
    }

    static class Account {
        String accountNumber;
        double balance;
        AccountType accountType;
    }

    enum AccountType {
        SAVINGS, CURRENT
    }

    static class CashDispenser {
        public Integer dispenseCash(Integer amount) {
            System.out.println("Dispensing cash: " + amount);
            return amount;
        }
    }

    static class CashDepositor {
        public boolean depositCash(Integer amount) {
            System.out.println("Depositing cash: " + amount);
            return true;
        }

        public boolean depositCheque(Integer amount) {
            System.out.println("Depositing cheque: " + amount);
            return true;
        }
    }

    static class CardSwiper {
        public void readCard(CardDetails card) {
            System.out.println("Card Swiped: " + card.cardNumber);
        }
    }

    // ----------- STRATEGY PATTERN FOR DEPOSITS -----------
    interface DepositStrategy {
        boolean deposit(Account account, int amount);
    }

    static class CashDeposit implements DepositStrategy {
        private final CashDepositor cashDepositor;

        public CashDeposit(CashDepositor depositor) {
            this.cashDepositor = depositor;
        }

        @Override
        public boolean deposit(Account account, int amount) {
            boolean success = cashDepositor.depositCash(amount);
            if (success) {
                account.balance += amount;
                System.out.println("Cash deposit successful.");
            }
            return success;
        }
    }

    static class ChequeDeposit implements DepositStrategy {
        private final CashDepositor cashDepositor;

        public ChequeDeposit(CashDepositor depositor) {
            this.cashDepositor = depositor;
        }

        @Override
        public boolean deposit(Account account, int amount) {
            boolean success = cashDepositor.depositCheque(amount);
            if (success) {
                account.balance += amount;
                System.out.println("Cheque deposit successful.");
            }
            return success;
        }
    }

    // ----------- ATM SERVICE LOGIC -----------
    static class ATMService {
        private final CashDispenser dispenser;

        public ATMService(CashDispenser dispenser) {
            this.dispenser = dispenser;
        }

        public boolean authenticate(CardDetails card, String pin) {
            return card.cardStatus == CardStatus.ACTIVE && pin.length() == 4;
        }

        public Account getAccountFromCard(CardDetails card) {
            Account account = new Account();
            account.accountNumber = card.accountNumber;
            account.accountType = AccountType.SAVINGS;
            account.balance = 5000.0; // Simulated lookup
            return account;
        }

        public double checkBalance(Account account) {
            System.out.println("Available balance: " + account.balance);
            return account.balance;
        }

        public boolean withdrawFunds(Account account, int amount) {
            if (account.balance >= amount) {
                dispenser.dispenseCash(amount);
                account.balance -= amount;
                System.out.println("Withdrawal successful.");
                return true;
            } else {
                System.out.println("Insufficient funds.");
                return false;
            }
        }

        public boolean depositFunds(Account account, int amount, DepositStrategy strategy) {
            return strategy.deposit(account, amount);
        }

        public boolean transferFunds(Account sender, Account receiver, int amount) {
            if (sender.balance >= amount) {
                sender.balance -= amount;
                receiver.balance += amount;
                System.out.println("Transfer successful.");
                return true;
            }
            System.out.println("Transfer failed. Insufficient balance.");
            return false;
        }
    }

    // ----------- SCREEN (SIMULATED UI) -----------
    static class Screen {
        public void showMenu(CardDetails card, ATMService atmService, String pin, CashDepositor depositor) {
            System.out.println("Welcome, " + card.userName);

            // ✅ Realistic: fetch actual account details
            Account acc = atmService.getAccountFromCard(card);

            System.out.println("1. Check Balance");
            atmService.checkBalance(acc);

            System.out.println("2. Withdraw Cash");
            atmService.withdrawFunds(acc, 200);

            System.out.println("3. Deposit Cash");
            DepositStrategy cashDeposit = new CashDeposit(depositor);
            atmService.depositFunds(acc, 500, cashDeposit);

            System.out.println("4. Deposit Cheque");
            DepositStrategy chequeDeposit = new ChequeDeposit(depositor);
            atmService.depositFunds(acc, 1000, chequeDeposit);
        }
    }

    // ----------- MAIN METHOD FOR DEMO -----------
    public static void main(String[] args) {
        Address atmAddress = new Address();
        atmAddress.city = "New Delhi";
        atmAddress.pin = 110001;
        atmAddress.state = "Delhi";
        atmAddress.country = "India";

        BankRegistrationDetail registration = new BankRegistrationDetail();
        registration.atmId = 101;
        registration.bankName = "ABC Bank";
        registration.registrationId = 123456;

        CardDetails userCard = new CardDetails();
        userCard.accountNumber = "ACC123";
        userCard.cardNumber = "CARD456";
        userCard.CVV = "123";
        userCard.cardType = CardType.VISA;
        userCard.expiryDate = new Date();
        userCard.userName = "John Doe";
        userCard.cardStatus = CardStatus.ACTIVE;

        ATM atm = new ATM(atmAddress, registration);
        atm.startATM(userCard, "1234");
    }
}
