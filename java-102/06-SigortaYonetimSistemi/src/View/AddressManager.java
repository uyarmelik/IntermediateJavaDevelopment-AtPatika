package View;

import Model.Address.Address;
import Model.Address.BusinessAddress;
import Model.Address.HomeAddress;
import ViewModel.Methods;
import java.util.ArrayList;
import java.util.Objects;

import static Model.User.selectUser;
import static View.AccountManager.runAccountManager;
import static ViewModel.Methods.*;

public class AddressManager {
    
    public static void runAddressManager(){
        System.out.println("\n-----------------");
        System.out.println("Address Processes");
        System.out.println("-----------------");
        System.out.println("1. Add Address");
        System.out.println("2. Remove Address");
        System.out.println("3. Back");
        System.out.println("-----------------");
        int secim = (int) Float.parseFloat(Methods.enterNumber("\nPlease select the process you want to take", 4, "0"));

        switch (secim) {
            case 1 -> addAddress();
            case 2 -> removeAddress();
            case 3 -> runAccountManager();
            default -> System.out.println("Please enter a valid value!");
        }
    }

    private static void addAddress() {
        System.out.println("\n1. Add Home Address");
        System.out.println("2. Add Business Address");
        System.out.println("3. Back");
        int choice = (int) Float.parseFloat(Methods.enterNumber("\nPlease select the process you want to take", 4, "0"));
        switch (choice) {
            case 1 -> {
                if (findUser() != null && selectUser!=null) {
                    if (Objects.requireNonNull(findUser()).getAddressList()==null){
                        String homeAddress = enterString("Home Address");
                        ArrayList<Address> selectAddressList = new ArrayList<>();
                        addHomeAddress(selectAddressList,homeAddress);
                        Objects.requireNonNull(findUser()).setAddressList(selectAddressList);
                        runAccountManager();
                    }
                    else{
                        String homeAddress = enterString("Home Address");
                        addHomeAddress(Objects.requireNonNull(findUser()).getAddressList(),homeAddress);
                    }
                }
            }
            case 2 ->{
                if (findUser() != null && selectUser!=null) {
                    if (Objects.requireNonNull(findUser()).getAddressList()==null){
                        String businessAddress = enterString("Business Address");
                        ArrayList<Address> selectAddressList = new ArrayList<>();
                        addBusinessAddress(selectAddressList,businessAddress);
                        Objects.requireNonNull(findUser()).setAddressList(selectAddressList);
                        runAccountManager();
                    }
                    else{
                        String businessAddress = enterString("Business Address");
                        addBusinessAddress(Objects.requireNonNull(findUser()).getAddressList(),businessAddress);
                    }
                }

            }
            case 3 -> runAccountManager();
            default -> System.out.println("Please enter a valid value!");
        }
    }

    public static void addHomeAddress(ArrayList<Address> addressList, String address){
        addressList.add(new HomeAddress(address));
    }

    public static void addBusinessAddress(ArrayList<Address> addressList, String address){
        addressList.add(new BusinessAddress(address));
    }

    public static void removeAddress(){
        if (findUser()!=null){
            if (Objects.requireNonNull(findUser()).getAddressList() == null || Objects.requireNonNull(findUser()).getAddressList().size()==0) System.out.println("Address not found!");
            else {
                int i=1, j=Objects.requireNonNull(findUser()).getAddressList().size();
                String formatString = "%-3s %-90s";
                System.out.printf("\n" + (formatString) + "%n", "", "Address:");
                for (Address address: Objects.requireNonNull(findUser()).getAddressList()){
                    System.out.printf((formatString) + "%n", i+".", address.getAddress());
                    i++;
                }
                int select = (int) Float.parseFloat(enterNumber("\nSelect address number",j+1, "-1") );
                while(select<1 || select>j ){
                    select = (int) Float.parseFloat(enterNumber("\nPlease enter a valid value",j+1, "-1") );
                }
                Objects.requireNonNull(findUser()).getAddressList().remove(select-1);
            }
        }
    }

}