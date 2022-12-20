package Comparator;
import Store.Computer;
import java.util.Comparator;

public class ComparatorComputerID implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getUniqueID().compareTo(o2.getUniqueID());
    }
}