package csim080.softeng206.contactmanager;

public class Contact {
	
	// Contact's fields
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String homeNumber;
	private String workNumber;
	private String emailAddress;
	private String homeAddress;
	private int pid; // Persond id 
	
	public Contact(String first, String middle, String last, String mobile, String home, String work, String homeAd, String email) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.mobileNumber = mobile;
		this.homeNumber = home;
		this.workNumber = work;
		this.emailAddress = email;
		this.homeAddress = homeAd;
		
		// Determine person ID
		
	}
	
	// Override toString() method
	public String toString() {
		return (firstName + middleName + lastName);
	}
	
	private int getId() {
		// blank
		return 0;
	}

}
