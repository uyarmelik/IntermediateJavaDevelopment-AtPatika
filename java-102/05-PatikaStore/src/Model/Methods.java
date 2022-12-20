package Model;
import Comparator.ComparatorComputerID;
import Comparator.ComparatorPhoneID;
import Store.Computer;
import Store.Phone;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.UUID;
import static Model.Brand.brandList;
import static Model.Brand.controlBrand;

public class Methods {

    private static final Scanner sc = new Scanner(System.in);
    private static final String formatS = "%-4s %-40s %-10s %-20s %-10s %-10s %-10s %-10s %-10s %-10s";
    private static int i = 1;

    public static void listBrandNameC(TreeSet<Computer> t){
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf((formatS) + "%n",
                "", "Computer ID:", "Brand:", "Computer Name:", "Cost:", "Discount:", "Stock:", "Memory:", "Power:", "RAM:");

        System.out.printf((formatS) + "%n",
                "", "------------", "------", "--------------", "-----", "---------", "------", "-------", "------", "----");

        for (Computer c: t){
            System.out.printf((formatS) + "%n",
                    i+".", c.getUniqueID(), c.getBrand().getName(), c.getName(), c.getCost(), c.getDiscount(), c.getStock(), c.getMemory(), c.getPower(), c.getRam());
            i++;
        }
        i=1;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }

    public static void listBrandIDC(TreeSet<Computer> t){
        TreeSet<Computer> computerListTemp = new TreeSet<>(new ComparatorComputerID());
        computerListTemp.addAll(t);
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf((formatS) + "%n",
                "", "Computer ID:", "Brand:", "Computer Name:", "Cost:", "Discount:", "Stock:", "Memory:", "Power:", "RAM:");

        System.out.printf((formatS) + "%n",
                "", "------------", "------", "--------------", "-----", "---------", "------", "-------", "------", "----");

        for (Computer c: computerListTemp){
            System.out.printf((formatS) + "%n",
                    i+".", c.getUniqueID(), c.getBrand().getName(), c.getName(), c.getCost(), c.getDiscount(), c.getStock(), c.getMemory(), c.getPower(), c.getRam());
            i++;
        }
        i=1;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }

    public static void addComputer(TreeSet<Computer> t){
        System.out.print("Computer Brands: - ");
        for (Brand b: brandList){
            System.out.print(b.getName() + " - ");
        }
        System.out.print("\nPlease write the computer brand of your choice: ");
        Brand brand = controlBrand(sc.next());

        System.out.print("Computer Name: ");
        String name = sc.next();

        float cost = Float.parseFloat(enterNumber("Cost", 100000));
        int discount = (int) Float.parseFloat(enterNumber("Discount", 100));
        int stock = (cost == 0) ? 0 : (int) Float.parseFloat(enterNumber("Stock", 7));
        int memory = (int) Float.parseFloat(enterNumber("Memory", 2000));
        int power = (int) Float.parseFloat(enterNumber("Power", 100));
        int ram = (int) Float.parseFloat(enterNumber("RAM", 128));

        Computer comp = new Computer(brand, UUID.randomUUID().toString(), name, cost, discount, stock, memory, power, ram);
        t.add(comp);
        System.out.println("Computer adding is successful.");

    }

    public static void removeComputer(TreeSet<Computer> t){
        listBrandIDC(t);
        System.out.print("\nPlease enter ID number: ");
        String id = sc.next();
        t.removeIf(c -> c.getUniqueID().equals(id));
        System.out.println("Remove completed.");

    }

    public static void listBrandNameP(TreeSet<Phone> t){
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf((formatS) + "%n",
                "", "Phone ID:", "Brand:", "Phone Name:", "Cost:", "Discount:", "Stock:", "Memory:", "Power:", "RAM:");

        System.out.printf((formatS) + "%n",
                "", "------------", "------", "--------------", "-----", "---------", "------", "-------", "------", "----");

        for (Phone p: t){
            System.out.printf((formatS) + "%n",
                    i+".", p.getUniqueID(), p.getBrand().getName(), p.getName(), p.getCost(), p.getDiscount(), p.getStock(), p.getMemory(), p.getPower(), p.getRam());
            i++;
        }
        i=1;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }

    public static void listBrandIDP(TreeSet<Phone> t){
        TreeSet<Phone> phoneListTemp = new TreeSet<>(new ComparatorPhoneID());
        phoneListTemp.addAll(t);
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf((formatS) + "%n",
                "", "Phone ID:", "Brand:", "Phone Name:", "Cost:", "Discount:", "Stock:", "Memory:", "Power:", "RAM:");

        System.out.printf((formatS) + "%n",
                "", "------------", "------", "--------------", "-----", "---------", "------", "-------", "------", "----");

        for (Phone p: phoneListTemp){
            System.out.printf((formatS) + "%n",
                    i+".", p.getUniqueID(), p.getBrand().getName(), p.getName(), p.getCost(), p.getDiscount(), p.getStock(), p.getMemory(), p.getPower(), p.getRam());
            i++;
        }
        i=1;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }

    public static void addPhone(TreeSet<Phone> t){
        System.out.print("Phone Brands: - ");
        for (Brand b: brandList){
            System.out.print(b.getName() + " - ");
        }
        System.out.print("\nPlease write the phone brand of your choice: ");
        Brand brand = controlBrand(sc.next());

        System.out.print("Phone Name: ");
        String name = sc.next();

        float cost = Float.parseFloat(enterNumber("Cost", 100000));
        int discount = (int) Float.parseFloat(enterNumber("Discount", 100));
        int stock = (cost == 0) ? 0 : (int) Float.parseFloat(enterNumber("Stock", 7));
        int memory = (int) Float.parseFloat(enterNumber("Memory", 2000));
        int power = (int) Float.parseFloat(enterNumber("Power", 100));
        int ram = (int) Float.parseFloat(enterNumber("RAM", 128));

        Phone pho = new Phone(brand, UUID.randomUUID().toString(), name, cost, discount, stock, memory, power, ram);
        t.add(pho);
        System.out.println("Phone adding is successful.");

    }

    public static void removePhone(TreeSet<Phone> t){
        listBrandIDP(t);
        System.out.print("\nPlease enter ID number: ");
        String id = sc.next();
        t.removeIf(c -> c.getUniqueID().equals(id));
        System.out.println("Remove completed.");

    }

    private static boolean numberControl(String s) {
        try {
            Float.parseFloat(s);
        } catch(NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static String enterNumber (String message, int large){
        System.out.print(message + ": ");
        String s = sc.next();
        while (numberControl(s)) {
            System.out.print("Please enter a number: ");
            s = sc.next();
        }

        if (Float.parseFloat(s)<large) return s;
        else return "0";
    }

}