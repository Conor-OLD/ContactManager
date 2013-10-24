package csim080.softeng206.contactmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ContactDatabase {
	// A singleton class that acts as a temporary database in memory that 
	// maintains a 'clean' copy of the contact database while it is in use
	// by the program; it is capable of performing methods that affect the
	// contacts in the database and the database as a whole and the class
	// is wholly responsible for reading and writing back to memory.

	private static ContactDatabase instance = null;
	
	private List<Contact> contactList;
	private int totalContacts; // This is a variable that will be used to
	// determine IDs for contacts as they are added;
	private Context context;
	
	// Private constructor due to singleton pattern
	private ContactDatabase (Context co) {
		// Set the database's android context
		context = co;
		
		// Initialize the contact list
		contactList = new ArrayList<Contact>();
		
		// Call the populate method with the constructor
		this.populateList();
		
	}
	
	// Implement singleton instance-returning method
	public static ContactDatabase getInstance(Context c) {
		if (instance == null ) {
			instance = new ContactDatabase(c);
		} else {
			ContactDatabase.destroyInstance();
			instance = new ContactDatabase(c);
		}
		return instance;
	}
	
	// Implement singleton instance-returning method (no creation, does not require
	// a context object)
	public static ContactDatabase getInstanceWithoutCreating() {
		return instance;
	}
	
	// This destroys the instance when it isn't needed, but calls the
	// 'finishOperations()' method first, which ensures that the filesystem
	// is synchronized with the state of the object before destruction.
	public static void destroyInstance() {
		instance.finishOperations();
		instance = null;
	}
	
	
	
	
	
	
	// Function that reads the list of contacts from memory
	public void populateList() {
		
		// Read the contents of the internal memory to the list of strings
		try {
			FileInputStream fin = context.openFileInput("contactFile.db");
			InputStreamReader in = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(in);
			
			String line = null;
			//String sep = System.getProperty("line.separator");
			StringBuffer sb = new StringBuffer();
			
			// Read initial line (totalContacts value)
			line = br.readLine();			
			try {
				totalContacts = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("Database is corrupt while reading totalContacts (" + line + "). Exiting...");
				System.exit(1);
			}
			
			Contact contact;
			int pid = 0;
			String first;
			String middle;
			String last;
			String mobile;
			String home;
			String work;
			String email;
			String homeAd;
			
			while ((line = br.readLine()) != null) {
				try {
					pid = Integer.parseInt(line);
					
				} catch (NumberFormatException e) {
					System.out.println("Database is corrupt while reading PID (" + line + "). Exiting...");
					// Assign a new pid
					
					pid = totalContacts + 1;
					
					//System.exit(1);
				}
				
				first = br.readLine();
				middle = br.readLine();
				last = br.readLine();
				mobile = br.readLine();
				home = br.readLine();
				work = br.readLine();
				email = br.readLine();
				homeAd = br.readLine();
				
				contact = new Contact(first, middle, last, mobile, home, work, email, homeAd);
				contact.setPid(pid);
				contactList.add(contact);
				
				
				//System.out.println("End of contact = " + homeAd); //DEBUG LINE
			}
			
			
			//Toast.makeText(context, "Successfully read file.", Toast.LENGTH_LONG).show(); // DEBUG line
			
			
			
		// If the file isn't found, there is no contact database, so create a
		// database that can be worked with.
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist, creating file."); // DEBUG line
			Toast.makeText(context, "File does not exist, creating file", Toast.LENGTH_LONG).show();
			
			// Create an empty contacts database file to start from
			try {
				FileOutputStream outputStream;
				outputStream = context.openFileOutput("contactFile.db", Context.MODE_PRIVATE);
				// Blank database will begin with 0, signifying that there
				// are no contacts in the database.
				outputStream.write("0".getBytes());
				outputStream.flush();
				outputStream.close();
				System.out.println("Write success"); // DEBUG line
				Toast.makeText(context, "Successfully created empty database file.", Toast.LENGTH_LONG).show(); // DEBUG line
			} catch (FileNotFoundException e2) {
				System.out.println("Cannot create empty database file."); // DEBUG line
			} catch (Exception e2) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveState() {
		if (instance != null) {
			instance.finishOperations();
		}
	}
	
	// Method that is called as the object is destroyed; it writes the
	// contact database (including the ID value) to file.
	private void finishOperations() {
		// Overwrite the datafile in memory with the up-to-date data
		try {
			FileOutputStream outputStream;
			outputStream = context.openFileOutput("contactFile.db", Context.MODE_PRIVATE);
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			// Append the max pid value to the top of the file, it will
			// be important for assigning IDs to future contacts
			sb.append(totalContacts);
			sb.append("\n");
			
			// Append the file-friendly versions of all the contacts
			for (Contact c : contactList) {
				sb.append(c.getFileFriendlyText());
			}
			
			outputStream.write(sb.toString().getBytes());
			outputStream.flush();
			outputStream.close();
			//System.out.println("Write success"); // DEBUG line
			//Toast.makeText(context, "Successfully rewrote database file.", Toast.LENGTH_LONG).show(); // DEBUG line
		} catch (FileNotFoundException e) {
			System.out.println("Cannot access database file."); // DEBUG line
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// This function simply adds a contact to the ArrayList of contacts
	// (the main data storage attribute of the class)
	public void addContact(Contact contact) {
		contactList.add(contact);
		totalContacts++;
	}
	
	// Deletes a contact from the list, by ID
	public void delete(int id) {
		// Create a temporary list of contacts, and add every
		// contact to that list that doesn't have the same ID as
		// the one being deleted.
		List<Contact> tempList = new ArrayList<Contact>();
		for (Contact c : contactList) {
			if (c.getID() != id) {
				tempList.add(c);
			}
		}
		contactList = tempList;
	}
	
	// Sort contact by first name
	public void sortFirst() {
		
		Collections.sort(contactList, new FirstNameComparator());
		
		// First in list must have PID 0, as to prevent an error that occurs
		// due to a newline always being written before the contact with 0 pid
		// So, the first contact in the newly sorted list must trade IDs with
		// the contact that current holds ID 0
		for (Contact c : contactList) {
			if (c.getID() == 0) {
				c.setPid(contactList.get(0).getID());
				contactList.get(0).setPid(0);
			}
		}
		
	}
	
	// Sort contact by last name
		public void sortLast() {
			
			Collections.sort(contactList, new LastNameComparator());
			
			// First in list must have PID 0, as to prevent an error that occurs
			// due to a newline always being written before the contact with 0 pid
			// So, the first contact in the newly sorted list must trade IDs with
			// the contact that current holds ID 0
			for (Contact c : contactList) {
				if (c.getID() == 0) {
					c.setPid(contactList.get(0).getID());
					contactList.get(0).setPid(0);
				}
			}
			
		}
		
	public Contact searchByString(String keyword) {
		// Stub method; will search contacts by first name, then last name
		// (maybe middle name as well, yet to be decided)
		return (new Contact("", "", "", "", "", "", "", ""));
	}
	
	// Getter for number of contacts that have ever existed in the database; 
	// used for determining the PID of a new contact. 
	// When there are 0 contacts in the database, this will be 0, so the first
	// time a contact is added, they will be assigned PID number 0. This
	// means that simply returning the value of 'totalContacts' will suffice
	// as a PID for a new contact. Adding a contact to the database will 
	// increment this number, so it will always be in sync with new contacts
	// being added.
	public int getANewID() {
		return totalContacts;
	}

	public List<Contact> getContactList() {
		return contactList;
	}
	
}
