package csim080.softeng206.contactmanager;

import java.util.Comparator;


// A custom comparator class for comparing contacts by their first name
public class LastNameComparator implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2) {
        return c1.getLastName().compareTo(c2.getLastName());
    }
}