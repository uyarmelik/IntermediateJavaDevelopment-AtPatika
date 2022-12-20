package Model;
import java.util.TreeSet;
import java.util.UUID;
import Comparator.ComparatorBrandName;

public class Brand {
    public static TreeSet<Brand> brandList = new TreeSet<>(new ComparatorBrandName());
    String formatS = "%-4s %-40s %-20s";
    private String uniqueID;
    private String name;

    public Brand() {
    }

    public Brand(String uniqueID, String name) {
        this.uniqueID = uniqueID;
        this.name = name;
    }

    static {
        createBrand();
    }

    private static void createBrand(){
        brandList.add(new Brand(UUID.randomUUID().toString(), "Samsung"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Lenovo"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Apple"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Huawei"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Casper"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Asus"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "HP"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Xiaomi"));
        brandList.add(new Brand(UUID.randomUUID().toString(), "Monster"));
    }

    public void printBrand(){
        int i=1;
        System.out.println("\n-----------------------------------------------------------");

        System.out.printf((formatS) + "%n", "", "Brand ID:", "Brand:");
        System.out.printf((formatS) + "%n", "", "---------", "------");
        for (Brand b: brandList){
            System.out.printf((formatS) + "%n", i + ".", b.getUniqueID(), b.getName());
            i++;
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }

    public static Brand controlBrand(String name){

        for (Brand b: brandList){
            if(name.equals(b.getName())) return b;
        }

        Brand brand = new Brand(UUID.randomUUID().toString(), name);
        brandList.add(brand);
        return brand;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

}