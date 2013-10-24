package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ContactDetail extends Activity {
	
	private Contact contact;
	
	// Override the onCreate class so that the activity can receive a contact
	// as an argument from the ListActivity screen
	protected void onCreate(Bundle savedInstanceState, Contact c) {
		super.onCreate(savedInstanceState);
		
		// Set the class' contact field according to the contact argument passed to it
		contact = c;
		
		setContentView(R.layout.activity_contact_detail);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_detail, menu);
		return true;
	}

}
