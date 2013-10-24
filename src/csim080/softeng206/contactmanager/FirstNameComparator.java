package csim080.softeng206.contactmanager;

import java.util.Comparator;


// A custom comparator class for comparing contacts by their first name
public class FirstNameComparator implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2) {
        return c1.getFirstName().compareTo(c2.getFirstName());
    }
}