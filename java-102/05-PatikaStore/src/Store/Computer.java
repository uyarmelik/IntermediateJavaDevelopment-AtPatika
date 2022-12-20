package Store;
import java.util.*;
import Comparator.ComparatorComputerName;
import Model.Brand;
import Model.Product;
import static Model.Methods.*;
import static Store.Store.run;

public class Computer extends Product {
    public static TreeSet<Computer> computerList = new TreeSet<>(new ComparatorComputerName());

    static {
        createComputer();
    }

    public Computer() {
    }

    public Computer(Brand brand, String uniqueID, String name, float cost, int discount, int stock, int memory, int power, int ram) {
        super(brand, uniqueID, name, cost, discount, stock, memory, power, ram);
    }

    protected void menu(){

        System.out.println("\n---------------------");
        System.out.println("1. List By Brand");
        System.out.println("2. List By ID");
        System.out.println("3. Add Computer");
        System.out.println("4. Remove Computer");
        System.out.println("5. Back");
        System.out.println("---------------------");
        int secim = (int) Float.parseFloat(enterNumber("\nPlease select the process you want to take", 6));

        switch (secim) {
            case 1 -> listBrandNameC(computerList);
            case 2 -> listBrandIDC(computerList);
            case 3 -> addComputer(computerList);
            case 4 -> removeComputer(computerList);
            case 5 -> run();
            default -> System.out.println("Please enter a valid value!");
        }
        menu();
    }

    private static void createComputer(){
        computerList.add(new Computer(
                controlBrand("Samsung"),
                UUID.randomUUID().toString(),
                "Galaxy Book S",
                9750f,
                5,
                1,
                256,
                45,
                8
        ));
        computerList.add(new Computer(
                controlBrand("Lenovo"),
                UUID.randomUUID().toString(),
                "V15",
                13692.27f,
                5,
                1,
                256,
                30,
                12
        ));
        computerList.add(new Computer(
                controlBrand("Asus"),
                UUID.randomUUID().toString(),
                "Rog Strix G15",
                22153.12f,
                8,
                2,
                1000,
                43,
                16
        ));
        computerList.add(new Computer(
                controlBrand("MSI"),
                UUID.randomUUID().toString(),
                "Katana GF66",
                28999.0f,
                2,
                4,
                512,
                26,
                32
        ));
    }

}