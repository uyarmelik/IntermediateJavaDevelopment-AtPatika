package View;

import Model.Insurance.*;
import ViewModel.Methods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import static Model.User.*;
import static View.AccountManager.runAccountManager;
import static ViewModel.Methods.findUser;

public class InsuranceManager {

    InsuranceManager(){
    }

    public static void runInsuranceManager(){
        System.out.println("\n-------------------");
        System.out.println("Insurance Processes");
        System.out.println("-------------------");
        System.out.println("1. Car Insurance");
        System.out.println("2. Health Insurance");
        System.out.println("3. Recidance Insurance");
        System.out.println("4. Travel Insurance");
        System.out.println("5. Insurance List");
        System.out.println("6. Back");
        System.out.println("---------------------------");
        int selection = (int) Float.parseFloat(Methods.enterNumber("\nPlease select the process you want to take", 7,"0"));

        switch (selection) {
            case 1, 2, 3, 4 -> addInsurance(selection);
            case 5 -> printInsuranceList();
            case 6 -> runAccountManager();
            default -> System.out.println("Please enter a valid value!");
        }
    }

    public static void addInsurance(int selection) {
        Insurance selectInsurance = null;
        switch (selection){
            case 1 -> selectInsurance = new CarInsurance("Car", 1000, LocalDate.now());
            case 2 -> selectInsurance = new HealthInsurance("Health", 2000, LocalDate.now());
            case 3 -> selectInsurance = new ResidenceInsurance("Residence", 5000, LocalDate.now());
            case 4 -> selectInsurance = new TravelInsurance("Travel", 500, LocalDate.now());
        }
        if (selectUser==null && findUser()==null) runAccountManager();
        else {
            if (Objects.requireNonNull(findUser()).getInsuranceList() != null) {
                Iterator<Insurance> it = Objects.requireNonNull(findUser()).getInsuranceList().iterator();
                while (it.hasNext()) {
                    switch (selection) {
                        case 1 -> {
                            if (it.next().getInsuranceName().equals("Car")) renewInsurance(selectInsurance);
                        }
                        case 2 -> {
                            if (it.next().getInsuranceName().equals("Health")) renewInsurance(selectInsurance);
                        }
                        case 3 -> {
                            if (it.next().getInsuranceName().equals("Residence")) renewInsurance(selectInsurance);
                        }
                        case 4 -> {
                            if (it.next().getInsuranceName().equals("Travel")) renewInsurance(selectInsurance);
                        }
                    }
                }
            }
            else{
                ArrayList<Insurance> selectInsuranceList = new ArrayList<>();
                selectInsuranceList.add(selectInsurance);
                Objects.requireNonNull(findUser()).setInsuranceList(selectInsuranceList);
                runAccountManager();
            }
        }
        Objects.requireNonNull(findUser()).getInsuranceList().add(selectInsurance);

    }

    public static void renewInsurance(Insurance selectInsurance){
        System.out.println("\n1. Renew");
        System.out.println("2. Back");
        int choice = (int) Float.parseFloat(Methods.enterNumber("\nPlease select the process you want to take", 3, "0"));
        switch (choice) {
            case 1 -> {
                if (Objects.requireNonNull(findUser()).getInsuranceList() != null) {
                    for (Insurance i: Objects.requireNonNull(findUser()).getInsuranceList()){
                        if (i.getInsuranceName().equals(selectInsurance.getInsuranceName())){
                            i.setInsuranceDate(LocalDate.now());
                            runAccountManager();
                        }
                    }
                }

            }
            case 2 -> runInsuranceManager();
            default -> System.out.println("Please enter a valid value!");
        }
    }

    public static void printInsuranceList(){
        int i=1;
        String formatString = "%-3s %-20s %-20s";
        if (selectUser!=null){
            if(Objects.requireNonNull(selectUser).getInsuranceList()!=null){
                System.out.printf("\n"+ formatString + "%n", "", "Insurance Name:", "Insurance Date:");
                for (Insurance insurance : Objects.requireNonNull(selectUser).getInsuranceList()) {
                    System.out.printf(formatString + "%n", i+".", insurance.getInsuranceName(), insurance.getInsuranceDate());
                    i++;
                }
            }
            else System.out.println("No registered insurance.");
        }
        else System.out.println("No registered insurance.");
    }
}