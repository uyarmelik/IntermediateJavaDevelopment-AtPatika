package ViewModel;

import Model.Address.Address;
import Model.AuthenticationStatus;
import Model.User;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static View.AddressManager.addBusinessAddress;
import static View.AddressManager.addHomeAddress;
import static ViewModel.Methods.enterString;
import static ViewModel.Methods.sc;

public class Account extends User {

    public Account(){}

    public static void signIn(){
        System.out.print("E-Mail: ");
        String email = sc.next();
        System.out.print("Password: ");
        String password = sc.next();
        if (userList == null) System.out.println("Login unsuccessful!");
        else{
            for (User u: userList){
                if (u.getEmail().equals(email.trim()) && u.getPassword().equals(password)) {
                    selectUser = u;
                    u.setAuthenticationStatus(AuthenticationStatus.SUCCESS);
                    System.out.println("Login successful.");
                    break;
                }
            }
        }
        if (selectUser==null) System.out.println("Login unsuccessful!");
    }

    public static void signUp(){
        String name = enterString("Name");
        String surname = enterString("Surname");
        String email = enterString("E-Mail");
        String password = enterString("Password");
        String job = enterString("Job");
        int age = (int) Float.parseFloat(Methods.enterNumber("Age", 150, "0"));
        String homeAddress = enterString("Home Address");
        String businessAddress = enterString("Business Address");
        ArrayList<Address> addressList = new ArrayList<>();
        addHomeAddress(addressList, homeAddress);
        addBusinessAddress(addressList, businessAddress);
        ZonedDateTime lastLogin = ZonedDateTime.now();
        User user = new User(UUID.randomUUID().toString(), name, surname, email, password, job, age, addressList, null, lastLogin, AuthenticationStatus.SUCCESS);
        selectUser=user;
        userList.add(user);
    }

    public static void logOut(){
        selectUser.setAuthenticationStatus(AuthenticationStatus.FAIL);
        selectUser = null;
    }

}