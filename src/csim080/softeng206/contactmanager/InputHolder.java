package csim080.softeng206.contactmanager;

import java.util.List;

import android.app.Activity;

public class InputHolder {
	// Class that holds user input
	// between activities so that it doesn't need to be re-entered
	// if the user goes back through windows of the add contact stage
	// Ultimately, a part of this will be done automatically; if a user
	// reaches stage 2 or 3 of the Add contact procedure, then the data in
	// the text boxes will persist as long as the respective activities remain
	// in the stack, which will be as long as the procedure as a whole
	// persists (i.e. until the user returns to the main menu somehow)
	// However, a separate class must be used to keep track of the input
	// data, as writing and reading from the datafile every time the activity
	// screen changes will be more complicated.
	
	// This class will also check to see if the values are valid and request
	// the user to re-enter them if not
	
	// Only one can be instantiated at once (singleton class), but it
	// can be associated with one of each of the activity classes that
	// require it. ## Singleton nature yet to be implemented

	
	
	private static InputHolder instance = null;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String homeNumber;
	private String workNumber;
	private String emailAddress;
	private String homeAddress;
	
	// Blank, private constructor; can only be 'called' with the getInstance()
	// method to prevent multiple instantiations
	private InputHolder() {
		// Nothing here
	}
	
	// Implement singleton instance-returning method
	public static InputHolder getInstance() {
		if (instance == null ) {
			instance = new InputHolder();
		}
		return instance;
	}
	
	// Method called to get names after first AddContact activity
	public void setNames(String first, String middle, String last) {
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	
	// Method called to get numbers & addresses after first AddContact activity
	public void setNumbers(String mob, String home, String work, String email, String homeAd) {
		mobileNumber = mob;
		homeNumber = home;
		workNumber = work;
		emailAddress = email;
		homeAddress = homeAd;		
	}

	
	// [Debugging only] Getter method for first name
	public String firstNameCall() {
		return firstName;
	}
	
	// This destroys the instance so that it doesn't persist if the user wants
	// to add another contact, which will require instantiating the class again,
	// which can only be done if the object field is NULL.
	public static void destroyInstance() {
		instance = null;
	}
	
	public Contact createContact() {
		// This creates a contact. This should only be performed once per 
		// instantiation of InputHolder, so it is appropriate that the 
		// instantiation is destroyed after the contact is created. This
		// cannot be done within this method, so it should be done as soon
		// as possible by the calling class.
		Contact contact = new Contact(firstName, middleName, lastName, mobileNumber, homeNumber, workNumber, homeAddress, emailAddress);
		return contact;
	}
	
	
}
