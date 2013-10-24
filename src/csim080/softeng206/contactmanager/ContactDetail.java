package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactDetail extends Activity {
	
	private static Contact contact;
	
	private TextView first;
	private TextView middle;
	private TextView last;
	private TextView mobile;
	private TextView home;
	private TextView work;
	private TextView homeAd;
	private TextView email;
	
	private Button editFirstButton;
	private Button editMiddleButton;
	private Button editLastButton;
	private Button editMobileButton;
	private Button editHomePhoneButton;
	private Button editWorkPhoneButton;
	private Button editEmailAddressButton;
	private Button editHomeAddressButton;
	
	private Button backButton;
	private Button deleteButton;
	
	// Override the onCreate class so that the activity can receive a contact
	// as an argument from the ListActivity screen
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_contact_detail);
		
		contact = ContactSingleton.getInstance();
		
		if (contact == null) {
			System.out.println("Error loading contact singleton class.");
		}
		
		first = (TextView) findViewById(R.id.textViewFirstNameData);
		first.setText(contact.getFirstName());
		
		middle = (TextView) findViewById(R.id.textViewMiddleNameData);
		middle.setText(contact.getMiddleName());
		
		last = (TextView) findViewById(R.id.textViewLastNameData);
		last.setText(contact.getLastName());
		
		mobile = (TextView) findViewById(R.id.textViewMobilePhoneData);
		mobile.setText(contact.getMobile());
		
		home = (TextView) findViewById(R.id.textViewHomePhoneData);
		home.setText(contact.getHomePhone());
		
		work = (TextView) findViewById(R.id.textViewWorkPhoneData);
		work.setText(contact.getWorkPhone());
		
		email = (TextView) findViewById(R.id.textViewEmailAddressData);
		email.setText(contact.getEmail());
		
		homeAd = (TextView) findViewById(R.id.textViewHomeAddressData);
		homeAd.setText(contact.getHomeAddress());
				
		backButton = (Button) findViewById(R.id.ContactDetailBack);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		// Listeners for all edit buttons
		
		editFirstButton = (Button)findViewById(R.id.FirstNameEdit);
		editFirstButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call editFunction with the appropriate field integer and string
				editFunction(v, 1, "first name");				
			}			
		});
		
		editMiddleButton = (Button)findViewById(R.id.MiddleNameEdit);
		editMiddleButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 2, "middle name");				
			}			
		});
		
		editLastButton = (Button)findViewById(R.id.LastNameEdit);
		editLastButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 3, "last name");				
			}			
		});
		
				
		editMobileButton = (Button)findViewById(R.id.MobilePhoneEdit);
		editMobileButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 4, "mobile number");				
			}			
		});
		
		editHomePhoneButton = (Button)findViewById(R.id.HomePhoneEdit);
		editHomePhoneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 5, "home number");				
			}			
		});
		
		editWorkPhoneButton = (Button)findViewById(R.id.WorkPhoneEdit);
		editWorkPhoneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 6, "work number");				
			}			
		});
		
		editEmailAddressButton = (Button)findViewById(R.id.EmailAddressEdit);
		editEmailAddressButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 7, "email address");				
			}			
		});
		
		editHomeAddressButton = (Button)findViewById(R.id.HomeAddressEdit);
		editHomeAddressButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editFunction(v, 8, "home address");				
			}			
		});
		
		
		deleteButton = (Button)findViewById(R.id.ContactDetailDelete);
		deleteButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ContactDatabase.getInstance(getApplicationContext()).delete((Integer)contact.getID());
				// Refresh the Contact database
				ContactDatabase.getInstance(getApplicationContext());
				
				// Return to main menu (and clears the stack, thus
            	// emptying it of the AddContact activity sequence)
				Intent intent = new Intent(getApplicationContext(), MainMenu.class);
				
				// Setting this flag upon a successful contact delete
				// will ensure that all activities (i.e., the ones that were opened during the 
				// addContact stage) will be removed from the stack
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);
			}
		});
		
	}
	
	
	
	// Function that is called by all the edit buttons with a different argument
	// to indicate what field needs to be edited
	public void editFunction(final View vi, final int field, final String fieldName) {
		AlertDialog.Builder ad = new AlertDialog.Builder(this);
		
		final EditText input = new EditText(this);
		
		ad.setView(input);
		ad.setMessage("Enter a new " + fieldName + " for " + contact.getFirstName());
		ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
									
			
            @Override
            public void onClick(DialogInterface ad, int which) {
                // This is a dialog box that informs the user that
            	// the contact was successfully created.
            	
            	String inputValue = input.getText().toString();
            	
            	// Don't do anything if the first name field is trying to be set to an empty
            	// value
            	if ((field == 1) && (inputValue.isEmpty())) {
            		Toast.makeText(vi.getContext(), "A contact must have a first name!", Toast.LENGTH_LONG).show(); // DEBUG line
            	} else {
            	
	            	// Conditional brackets for deciding what contact detail to edit
	            	if (field == 1) {
	            		contact.setFirstName(inputValue);
	            		first.setText(inputValue);
	            	} else if (field == 2) {
	            		contact.setMiddleName(inputValue);
	            		middle.setText(inputValue);
	            	} else if (field == 3) {
	            		contact.setLastName(inputValue);
	            		last.setText(inputValue);
	            	} else if (field == 4) {
	            		contact.setMobile(inputValue);
	            		mobile.setText(inputValue);
	            	} else if (field == 5) {
	            		contact.setHomePhone(inputValue);
	            		home.setText(inputValue);
	            	} else if (field == 6) {
	            		contact.setWorkPhone(inputValue);
	            		work.setText(inputValue);
	            	} else if (field == 7) {
	            		contact.setEmail(inputValue);
	            		email.setText(inputValue);
	            	} else if (field == 8) {
	            		contact.setHomeAddress(inputValue);
	            		if (inputValue == null) {
	            			homeAd.setText("");
	            		} else {
	            			homeAd.setText(inputValue);
	            		}
	            	} 
	            	//Toast.makeText(vi.getContext(), inputValue, Toast.LENGTH_LONG).show(); // DEBUG line
	
	            	// Refresh the contact database in the filesystem so that it is made 
	            	// up-to-date whenever a change is made, without having to wait for 
	            	// user to close activities.
	            	ContactDatabase.saveState();
            	}
			}
            
		});
        
		ad.show();
	}
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_detail, menu);
		return true;
	}

}
