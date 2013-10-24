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
		
		homeAd = (TextView) findViewById(R.id.textViewEmailAddressData);
		homeAd.setText(contact.getEmail());
		
		email = (TextView) findViewById(R.id.textViewHomeAddressData);
		email.setText(contact.getHomeAddress());
		
		backButton = (Button) findViewById(R.id.ContactDetailBack);
		editFirstButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		editFirstButton = (Button)findViewById(R.id.FirstNameEdit);
		editFirstButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(v.getContext(), "Toast debug", Toast.LENGTH_LONG).show(); // DEBUG line
				
				// Call editFunction with the appropriate field integer and string
				editFunction(v, 1, "first name");
				
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
            	}
            	
            	// Conditional brackets for deciding what contact detail to edit
            	if (field == 1) {
            		contact.setFirstName(inputValue);
            		first.setText(inputValue);
            	}
            	
            	// It returns to main menu (and clears the stack, thus
            	// emptying it of the AddContact activity sequence)
				//Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            	
            	//Toast.makeText(vi.getContext(), inputValue, Toast.LENGTH_LONG).show(); // DEBUG line
				
            	// Setting this flag upon a successful series of AddContact activities
				// will ensure that all activities (i.e., the ones that were opened during the 
				// addContact stage) will be removed from the stack
				//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				//intent.putExtra("EXIT", true);
				//startActivity(intent);
            	
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
