package csim080.softeng206.contactmanager;

public class ContactSingleton {
	
	// Singleton Contact class is used to hold a single contact while the 
	// 'view contact detail' activity is being used
	
	private static Contact instance = null;
	private static ContactSingleton singleton = null;
	
	// Id must also be passed into the constructor so that it can be set
	
	private ContactSingleton(Contact c) {
		instance = c;		
	}
	
	
	// Implement singleton instance-returning method
	public static Contact getInstance() {		
		return instance;
	}
	
	// Implement singleton instance creation method
	public static void createInstance(Contact contact) {
		
		ContactSingleton.destroyInstance();
		
		if (instance == null ) {
			singleton = new ContactSingleton(contact);
		}
	}
	
	
	
	// This destroys the instance so that it doesn't persist if the user wants
	// to view another contact, which will require instantiating the class again,
	// which can only be done if the object field is NULL.
	// This only needs to be called upon creation of a new instance, so it is private
	// and will be called at the beginning of createInstance()
	private static void destroyInstance() {
		instance = null;
	}
	
}
