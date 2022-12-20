package Comparator;
import java.util.Comparator;
import Model.Brand;

public class ComparatorBrandName implements Comparator<Brand> {
    @Override
    public int compare(Brand o1, Brand o2) {
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}