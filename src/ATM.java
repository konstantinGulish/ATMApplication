import java.util.Scanner;
public class ATM {

    public static void main(String[] args) {

    // create a new account
        Account acct1 = new Account(1111, "Joe", 50, 2222);

        //prompt user for account number
        System.out.println(promptUserForAccount());

        //read in account number
        int accountNumber = getAccountNumber();

        //prompt user for PIN number
        System.out.println(promptUserForPin());

        //read in PIN
        int pin = getPin();

        int numberOfAttempts = 0;
        while (!(acct1.validateAccount(accountNumber) &&
        acct1.validatePin(pin))){
            if (!acct1.validateAccount(accountNumber)) {
                System.out.println(displayIncorrectAccountError());
                System.out.println(promptUserForAccount());
                accountNumber = getAccountNumber();
            }
            if (!acct1.validatePin(pin)){
                System.out.println(displayIncorrectPin());
                System.out.println(promptUserForPin());
                pin = getPin();
            }
            numberOfAttempts++;
            if (numberOfAttempts >= 3) break;
        }
        while (readInChoiceToContinue()) {

            System.out.println(displayMenu());
            int menuChoice = readInMenuChoice();
            while (!isValidMenuChoice(menuChoice)) {
                System.out.println(displayInvalidMenuChoiceError());
                System.out.println(displayMenu());
                menuChoice = readInMenuChoice();
            }

            if (menuChoice == 1) {
                System.out.println(displayBalance(acct1));
            } else if (menuChoice == 2) {
                System.out.println(displayDepositAmountQuery());
                System.out.println(acct1.deposit(readInDepositAmount()));
            } else if (menuChoice == 3) {
                System.out.println(displayWithdrawalAmountQuery());
                System.out.println(acct1.withdraw(readInWithdrawalAmount()));
            }
        }

        System.out.println(displayThankYouMessage ());

    }

    public static String promptUserForAccount () {
        return "Please enter your account number: ";
        }

    public static String promptUserForPin () {
        return "Please enter your PIN: ";
    }

    public static String displayIncorrectAccountError () {
        return "The account number is incorrect: ";
    }

    public static String displayIncorrectPin () {
        return "The pin number is incorrect: ";
    }

    public static int getAccountNumber (){
        Scanner in = new Scanner(System.in);
        int accountNumber = in.nextInt();
        return accountNumber;
    }

    public static int getPin () {
        Scanner in = new Scanner(System.in);
        int pin = in.nextInt();
        return pin;
    }

    public static String displayMenu (){
        return "Please choose one of the options below:\n" +
        "1. Balance inquiry\n" +
        "2. Deposit\n" +
        "3. Withdrawal\n";
    }

    public static int readInMenuChoice (){
        Scanner in = new Scanner(System.in);
        int menuChoice = in.nextInt();
        return menuChoice;
    }

    public static boolean isValidMenuChoice (int menuChoice) {
        if (menuChoice < 1 || menuChoice > 3) return false;
        return true;
    }

    public static String displayInvalidMenuChoiceError() {
        return "The menu choice you entered is not valid. " +
                "Please enter one of the options in the menu.";
    }

    public static String displayBalance (Account acct){
        return "The balance in your account is " + "$" +
                String .format("%.2f",acct.getBalance());
    }

    public static String displayDepositAmountQuery () {
        return "How much do you wish to deposit?";
    }

    public static String displayWithdrawalAmountQuery (){
        return "How much do you wish to withdraw?";
    }

    public static double readInDepositAmount (){
        Scanner in = new Scanner(System.in);
        double depositAmount = in.nextDouble();
        return depositAmount;
    }

    public static double readInWithdrawalAmount (){
        Scanner in = new Scanner(System.in);
        double withdrawalAmount = in.nextDouble();
        return withdrawalAmount;
    }

    public static String displayThankYouMessage (){
        return "Thank you for using the ATM";
    }

    public static String promptUserToContinue (){
        return "Do you wish to continue? (y/n)";
    }

    public static boolean readInChoiceToContinue (){
        System.out.println(promptUserToContinue());
        Scanner in = new Scanner(System.in);
        String userChoice = in.next();
        if (!userChoice.equalsIgnoreCase("n")) return true;
        return false;
    }
}