package csim080.softeng206.contactmanager;

import java.util.List;

public class ContactDatabase {
	// Stub class consisting of a list of contacts and stub methods,
	// acts as a database of contacts that can be accessed and modified
	// using said functions

	private List<Contact> contactList;
	
	public void addContact(Contact contact) {
		contactList.add(contact);
	}
	
	public void delete(Contact contact) {
		// Stub
	}
	
	public void sortFirst() {
		// Stub; sorts existing list by their respective first name attributes
	}
	
	public void sortLast() {
		// Stub; sorts existing list by their last name attributes
	}
		
	public Contact searchByString(String keyword) {
		// Stub method; will search contacts by first name, then last name
		// (maybe middle name as well, yet to be decided)
		return (new Contact("", "", "", 0));
	}
	
}
