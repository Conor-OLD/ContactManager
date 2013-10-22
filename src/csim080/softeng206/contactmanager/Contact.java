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
	
	public Contact(String first, String middle, String last, String mobile, String home, String work, String email, String homeAd) {
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
	

	// Method that returns a string that can be written straight to a file.
	public String getFileFriendlyText() {
		StringBuilder sb = new StringBuilder();
		
		// A special case in which a newline is not written at the beginning
		// of a fileFriendlyString exists, which is the case when the contact
		// in question has a pid if 0 (i.e. is the first contact in the
		// database). It is not written because a newline is always written
		// after the first line of the file (the totalContacts value).
		// Otherwise, a newline will need to be written to seperate two
		// contacts' relative details in the file.
		if (this.pid != 0) {
			sb.append("\n");
		}
		
		sb.append(pid + "\n");
		sb.append(firstName + "\n");
		sb.append(middleName + "\n");
		sb.append(lastName + "\n");
		sb.append(mobileNumber + "\n");
		sb.append(homeNumber + "\n");
		sb.append(workNumber + "\n");
		sb.append(emailAddress + "\n");
		sb.append(homeAddress); // Last entry will not have another newline
		
		return sb.toString();
	}

	// Setter method for person id attribute
	public void setPid(int p) {
		this.pid = p;		
	}

}
