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
	
	//private List<Activity> subscribers;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private int mobileNumber;
	private int homeNumber;
	private int workNumber;
	private String emailAddress;
	private String homeAddress;
	
	// Blank constructor
	public InputHolder() {
		// Nothing here
	}
	
	// Method called to get names after first AddContact activity
	public void getNames(String first, String middle, String last) {
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	
	// Method called to get numbers & addresses after first AddContact activity
	public void getNumbers(int mob, int home, int work, String email, String homeAd) {
		mobileNumber = mob;
		homeNumber = home;
		workNumber = work;
		emailAddress = email;
		homeAddress = homeAd;		
	}
	
	
}
