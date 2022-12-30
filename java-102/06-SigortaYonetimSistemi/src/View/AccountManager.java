package View;

import ViewModel.Methods;
import ViewModel.Account;
import static View.AddressManager.runAddressManager;
import static View.InsuranceManager.*;

public class AccountManager extends Account {

    public AccountManager(){
    }

    public static void runAccountManager() {
        if (selectUser==null) statusFail();
        else statusSuccess();
        runAccountManager();
    }

    private static void statusSuccess(){
        System.out.println("\n--------------------");
        System.out.println("Processes");
        System.out.println("--------------------");
        System.out.println("1. Address Process");
        System.out.println("2. Insurance Process");
        System.out.println("3. Log Out");
        System.out.println("--------------------");
        int secim = (int) Float.parseFloat(Methods.enterNumber("\nPlease select the process you want to take", 4, "0"));

        switch (secim) {
            case 1 -> runAddressManager();
            case 2 -> runInsuranceManager();
            case 3 -> logOut();
            default -> System.out.println("Please enter a valid value!");
        }
    }

    private static void statusFail(){
        System.out.println("\n---------------------------");
        System.out.println("Insurance Management System");
        System.out.println("---------------------------");
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.println("---------------------------");
        int secim = (int) Float.parseFloat(Methods.enterNumber("\nPlease select the process you want to take", 5, "0"));

        switch (secim) {
            case 1 -> signIn();
            case 2 -> signUp();
            case 3 -> System.exit(0);
            default -> System.out.println("Please enter a valid value!");
        }
    }

}