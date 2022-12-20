package Store;
import Model.Brand;
import static Model.Methods.enterNumber;

public class Store {

    public static void run(){
        System.out.println("\n-----------------------------");
        System.out.println("Patika Store Management Panel");
        System.out.println("-----------------------------");
        System.out.println("1. Brands");
        System.out.println("2. Phones");
        System.out.println("3. Computers");
        System.out.println("4. Exit Panel");
        System.out.println("-----------------------------");
        int secim = (int) Float.parseFloat(enterNumber("\nPlease select the process you want to take", 5));

        switch (secim) {
            case 1 -> {
                Brand b = new Brand();
                b.printBrand();
            }
            case 2 -> {
                Phone p = new Phone();
                p.menu();
            }
            case 3 -> {
                Computer c = new Computer();
                c.menu();
            }
            case 4 -> System.exit(0);
            default -> System.out.println("Please enter a valid value!");
        }

        run();
    }

}