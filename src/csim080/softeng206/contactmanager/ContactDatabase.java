package csim080.softeng206.contactmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ContactDatabase {
	// Stub class consisting of a list of contacts and stub methods,
	// acts as a database of contacts that can be accessed and modified
	// using said functions

	private List<Contact> contactList;
	private Context context;
		
	public ContactDatabase (Context co) {
		
		/*
		
		// Set the database's android context
		context = co;
		
		// Get the Android file directory that the database will be stored in
		// The directory will be ContactManager
		File fileDirectory = new File(context.getFilesDir(), "ContactManager");
		// The datafile will be "contacts.txt"
		File fullPath = new File(fileDirectory, "contacts.txt");
		
		//System.out.println("Opened location: " + fullPath.toString()); // DEBUG line
		
		
		// Call the populate method
		this.populateList();
		
		/*try {
			FileOutputStream outputStream;
			outputStream = context.openFileOutput("testfile.txt", Context.MODE_PRIVATE);
			outputStream.write("0xffff".getBytes());
			outputStream.flush();
			outputStream.close();
			System.out.println("Write success"); // DEBUG line
			Toast.makeText(context, "Successfully wrote TestWrite", Toast.LENGTH_LONG).show(); // DEBUG line
			  
		} catch (FileNotFoundException e) {
			System.out.println("Write fail"); // DEBUG line
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fin = context.openFileInput("testfile.txt");
			InputStreamReader in = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(in);
			
			String line = null;
			String sep = System.getProperty("line.separator");
			StringBuffer sb = new StringBuffer();
			
			while ((line = br.readLine()) != null)
				sb.append(line).append(sep);
			
			String done = sb.toString();
			Toast.makeText(context, "Successfully read " + done, Toast.LENGTH_LONG).show(); // DEBUG line
			
		} catch (FileNotFoundException e) {
			System.out.println("cant read from file"); // DEBUG line
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		*/
		
	}
	
	// Function that reads the list of contacts from memory
	public void populateList() {
		// Instantiate a list of strings that will hold the raw lines that
		// are read from the device's internal memory
		List<String> lines = new ArrayList<String>();
		
		// Read the contents of the internal memory to the list of strings
		try {
			FileInputStream fin = context.openFileInput("contactFile.db");
			InputStreamReader in = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(in);
			
			String line = null;
			String sep = System.getProperty("line.separator");
			StringBuffer sb = new StringBuffer();
			
			while ((line = br.readLine()) != null)
				sb.append(line).append(sep);
			
			String done = sb.toString();
			Toast.makeText(context, "Successfully read " + done, Toast.LENGTH_LONG).show(); // DEBUG line
			
		// If the file isn't found, there is no contact database, so create a
		// database that can be worked with.
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist, creating file."); // DEBUG line
			Toast.makeText(context, "File does not exist, creating file", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		/*try {
			FileOutputStream outputStream;
			outputStream = context.openFileOutput("testfile.txt", Context.MODE_PRIVATE);
			outputStream.write("0xffff".getBytes());
			outputStream.flush();
			outputStream.close();
			System.out.println("Write success"); // DEBUG line
			Toast.makeText(context, "Successfully wrote TestWrite", Toast.LENGTH_LONG).show(); // DEBUG line
			  
		} catch (FileNotFoundException e) {
			System.out.println("Write fail"); // DEBUG line
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
	}
	
	public void addContact(Contact contact) {
		contactList.add(contact);
	}
	
	public void delete(Contact contact) {
		// Stub
	}
	
	// Sort contact by first name
	public void sortFirst() {
		List<Contact> tempContList = new ArrayList<Contact>();
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
