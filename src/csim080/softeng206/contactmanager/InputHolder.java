package csim080.softeng206.contactmanager;

import java.util.List;

import android.app.Activity;

public class InputHolder {
	// Stub class that will be implemented to hold user input
	// between activities so that it doesn't need to be re-entered
	// if the user goes back through windows of the add contact stage
	
	// Only one can be instantiated at once (singleton class), but it
	// can be associated with one of each of the activity classes that
	// require it.
	
	private List<Activity> subscribers;
	
}
