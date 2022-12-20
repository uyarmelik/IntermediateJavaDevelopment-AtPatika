package Comparator;

import Store.Phone;

import java.util.Comparator;

public class ComparatorPhoneID implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getUniqueID().compareTo(o2.getUniqueID());
    }
}