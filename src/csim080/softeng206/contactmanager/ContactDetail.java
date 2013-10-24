package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ContactDetail extends Activity {
	
	private static Contact contact;
	
	// Override the onCreate class so that the activity can receive a contact
	// as an argument from the ListActivity screen
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_contact_detail);
		
		contact = ContactSingleton.getInstance();
		
		if (contact == null) {
			System.out.println("Error loading contact singleton class.");
		}
		
		TextView first;
		TextView middle;
		TextView last;
		TextView mobile;
		TextView home;
		TextView work;
		TextView homeAd;
		TextView email;
		
		first = (TextView) findViewById(R.id.textViewLastNameData);
		first.setText(contact.toString());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_detail, menu);
		return true;
	}

}
