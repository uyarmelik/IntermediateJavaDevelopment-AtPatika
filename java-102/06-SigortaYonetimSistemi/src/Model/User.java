package Model;

import Model.Address.Address;
import Model.Address.BusinessAddress;
import Model.Address.HomeAddress;
import Model.Insurance.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static java.time.LocalDate.of;

public class User {

    public static ArrayList<User> userList = new ArrayList<>(1);
    public static User selectUser = null;

    private String uniqueID;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> addressList;
    private ArrayList<Insurance> insuranceList;
    private ZonedDateTime lastLogin;
    private AuthenticationStatus authenticationStatus;

    public User(String uniqueID, String name, String surname, String email, String password, String job, int age, ArrayList<Address> addressList, ArrayList<Insurance> insuranceList, ZonedDateTime lastLogin, AuthenticationStatus authenticationStatus) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addressList = addressList;
        this.insuranceList = insuranceList;
        this.lastLogin = lastLogin;
        this.authenticationStatus = authenticationStatus;
    }

    public User(){}

    static {
        createRandomUser();
    }

    private static void createRandomUser() {
        ArrayList<Address> address1 = new ArrayList<>();
        address1.add(new HomeAddress("Paris/France"));
        address1.add(new BusinessAddress("London/England"));
        ArrayList<Insurance> insurance1 = new ArrayList<>();
        insurance1.add(new CarInsurance("Volvo", 5000, of(Integer.parseInt("2020"), Integer.parseInt("1"), Integer.parseInt("2"))));
        User user1 = new User(UUID.randomUUID().toString(), "Soner", "Berk", "sonerberk@gmail.com", "sonerberk123", "Developer", 33, address1, insurance1, ZonedDateTime.now(), AuthenticationStatus.FAIL);

        ArrayList<Address> address2 = new ArrayList<>();
        address2.add(new HomeAddress("Madrid/Spain"));
        address2.add(new BusinessAddress("Istanbul/Turkey"));
        ArrayList<Insurance> insurance2 = new ArrayList<>();
        insurance2.add(new HealthInsurance("Memorial", 12000, of(2021, 3, 5)));
        User user2 = new User(UUID.randomUUID().toString(), "Gizem", "Gezgen", "gezgengizem@gmail.com", "gezgengizem123", "Youtuber", 23, address2, insurance2, ZonedDateTime.now(), AuthenticationStatus.FAIL);

        userList.add(user1);
        userList.add(user2);
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

}