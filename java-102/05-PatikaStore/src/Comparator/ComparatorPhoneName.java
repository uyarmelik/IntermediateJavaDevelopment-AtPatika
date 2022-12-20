package Comparator;

import Store.Phone;

import java.util.Comparator;

public class ComparatorPhoneName implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getBrand().getName().toLowerCase().compareTo(o2.getBrand().getName().toLowerCase());
    }
}