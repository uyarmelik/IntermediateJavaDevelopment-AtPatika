package Store;
import java.util.*;
import Model.Brand;
import Model.Product;
import static Model.Methods.*;
import static Store.Store.run;
import Comparator.ComparatorPhoneName;

public class Phone extends Product {
    public static TreeSet<Phone> phoneList = new TreeSet<>(new ComparatorPhoneName());

    static {
        createPhone();
    }

    public Phone() {
    }

    public Phone(Brand brand, String uniqueID, String name, float cost, int discount, int stock, int memory, int power, int ram) {
        super(brand, uniqueID, name, cost, discount, stock, memory, power, ram);
    }

    protected void menu(){

        System.out.println("\n---------------------");
        System.out.println("1. List By Brand");
        System.out.println("2. List By ID");
        System.out.println("3. Add Phone");
        System.out.println("4. Remove Phone");
        System.out.println("5. Back");
        System.out.println("---------------------");
        int secim = (int) Float.parseFloat(enterNumber("\nPlease select the process you want to take", 6));

        switch (secim) {
            case 1 -> listBrandNameP(phoneList);
            case 2 -> listBrandIDP(phoneList);
            case 3 -> addPhone(phoneList);
            case 4 -> removePhone(phoneList);
            case 5 -> run();
            default -> System.out.println("Please enter a valid value!");
        }
        menu();
    }

    private static void createPhone(){
        phoneList.add(new Phone(
                controlBrand("Apple"),
                UUID.randomUUID().toString(),
                "iPhone 11",
                17400f,
                10,
                1,
                128,
                25,
                4
        ));
        phoneList.add(new Phone(
                controlBrand("Oppo"),
                UUID.randomUUID().toString(),
                "A16",
                4198.99f,
                5,
                2,
                64,
                80,
                4
        ));
        phoneList.add(new Phone(
                controlBrand("Huawei"),
                UUID.randomUUID().toString(),
                "P20 Lite",
                3799f,
                1,
                5,
                128,
                55,
                4
        ));
    }

}