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
	private int pid; // Person id; this will be used to ensure that photos
	// are always associated with the right person, and to ensure a difference
	// between contacts that would otherwise be identical.
	
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
		//==not yet implemented, stub implementation==
		this.pid = 0;
	}
	
	// Override toString() method
	public String toString() {
		if (lastName.isEmpty()) {
			return firstName;
		} else {
			return (firstName + " " + lastName);
		}
		
	}
	
	private int getId() {
		// blank
		return 0;
	}

	// Method that returns a string that can be written straight to a file.
	public String getFileFriendlyText() {
		StringBuilder sb = new StringBuilder();
		sb.append(pid + "\n");
		sb.append(firstName + "\n");
		sb.append(middleName + "\n");
		sb.append(lastName + "\n");
		sb.append(mobileNumber + "\n");
		sb.append(homeNumber + "\n");
		sb.append(workNumber + "\n");
		sb.append(emailAddress + "\n");
		sb.append(homeAddress + "\n");
		
		return sb.toString();
	}

}
