package ViewModel;

import Model.User;
import java.util.Scanner;

import static Model.User.selectUser;
import static Model.User.userList;

public class Methods {

    public static final Scanner sc = new Scanner(System.in);

    public static String enterString(String message){
        System.out.print(message + ": ");
        return sc.next();
    }

    public static String enterNumber (String message, int size, String elseValue){
        System.out.print(message + ": ");
        String s = sc.next();
        while (numberControl(s)) {
            System.out.print("Please enter a valid number: ");
            s = sc.next();
        }

        if (Float.parseFloat(s)<size) return s;
        else return elseValue;
    }

    private static boolean numberControl(String s) {
        try {
            Float.parseFloat(s);
        } catch(NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static User findUser(){
        if (selectUser!=null && userList!=null){
            for(User u: userList){
                if (u.getUniqueID().equals(selectUser.getUniqueID())) return u;
            }
        }
        return null;
    }

}