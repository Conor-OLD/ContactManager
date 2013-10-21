package csim080.softeng206.contactmanager;

public class Contact {
	
	// Contact's fields
	private String firstName;
	private String middleName;
	private String lastName;
	private int mobileNumber;
	private int homeNumber;
	private int workNumber;
	private String emailAddress;
	private String homeAddress;
	
	public Contact(String first, String middle, String last, int mobile) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.mobileNumber = mobile;
	}
	
	// Override toString() method
	public String toString() {
		return (firstName + middleName + lastName);
	}

}
