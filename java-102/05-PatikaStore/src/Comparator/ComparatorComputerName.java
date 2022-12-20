package Comparator;
import Store.Computer;
import java.util.Comparator;

public class ComparatorComputerName implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getBrand().getName().toLowerCase().compareTo(o2.getBrand().getName().toLowerCase());
    }
}